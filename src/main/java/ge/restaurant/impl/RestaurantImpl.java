package ge.restaurant.impl;

import ge.restaurant.dto.*;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.models.*;
import ge.restaurant.repository.*;
import ge.restaurant.service.RecommendationService;
import ge.restaurant.service.RegistrationService;
import ge.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.*;

@Service
@Transactional
public class RestaurantImpl implements RestaurantService {
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private AverageRatingRepository averageRatingRepository;
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RecommendationService recommendationService;


    @Override
    public List<Restaurant> register(List<RestaurantDto> restaurantDtos) throws DataAlreadyExistException {
        List<Restaurant> restaurants=new ArrayList<>();
        for (RestaurantDto restaurantDto : restaurantDtos) {
            if (iseExist(restaurantDto.getEmail())) {
                throw new DataAlreadyExistException("This restaurant already exist");
            }
            String encPass = registrationService.encodePassword(restaurantDto.getPassword());
            Set<Role> roleSet = registrationService.role(restaurantDto.getRole());
            Addresses addresses = new Addresses(restaurantDto.getStreet(), restaurantDto.getStreetNumber(), restaurantDto.getDistrict());
            Restaurant restaurant = restaurantRepository.save(new Restaurant(0L, restaurantDto.getEmail(), restaurantDto.getUserName(),
                    restaurantDto.getType(), restaurantDto.getPhoneNumber(), encPass, roleSet, addresses));
            Users user = userRepository.findById(1L).get();
            Rating rating =
                    new Rating(restaurant, user, 0f, null,
                            0f, 0f, 0f, 0f);
            AverageRating averageRating =
                    new AverageRating(0f, 0f, 0f, 0f, 0f, restaurant);
            averageRatingRepository.save(averageRating);
            ratingRepository.save(rating);
            restaurants.add(restaurant);
        }
        return restaurants;
    }

    public RestaurantMainDto getAllRestaurant() {

        List<AverageRating> allRestaurantWithAverageRating =
                averageRatingRepository.getAllRestaurantWithAverageRating();
        Set<String> allUniqueTypes = restaurantRepository.findAllUniqueTypes();
        Set<String> allUniqueDistrict = restaurantRepository.getAllUniqueDistinct();
        return new RestaurantMainDto(allRestaurantWithAverageRating, allUniqueTypes, allUniqueDistrict);
    }

    public TypeAndDistrict getAllTypeAndDistrict(){
        Set<String> allUniqueTypes = restaurantRepository.findAllUniqueTypes();
        Set<String> allUniqueDistrict = restaurantRepository.getAllUniqueDistinct();
        return new TypeAndDistrict(allUniqueTypes,allUniqueDistrict);
    }

    public List<AverageRating> getRestaurantByType(Set<String> type) {
        return averageRatingRepository.findRestaurantsByTypes(type);
    }

    public List<AverageRating> getRestaurantByRating(String min, String max) {
        Float minRating = parseFloatOrDefault(min, 0f);
        Float maxRating = parseFloatOrDefault(max, 5f);
        return averageRatingRepository.findRatingsByAverageRatingRange(minRating, maxRating);
    }


    public List<AverageRating> getRestaurantByDistrict(Set<String> district) {
        return averageRatingRepository.findRestaurantsByDistrict(district);
    }

    public List<AverageRating> getRestaurantByTypeAndRating(Set<String> type, String min, String max) {
        Float minRating = parseFloatOrDefault(min, 0f);
        Float maxRating = parseFloatOrDefault(max, 5f);
        return averageRatingRepository.findRestaurantsByTypesAndRating(type, minRating, maxRating);
    }

    public List<AverageRating> getRestaurantByTypeAndDistinct(Set<String> type,Set<String> distinct){
        return averageRatingRepository.findRestaurantsByTypesAndDistinct(type,distinct);
    }

    public List<AverageRating> getRestaurantByDistinctAndRating(Set<String> distinct,String min, String max){
        Float minRating = parseFloatOrDefault(min, 0f);
        Float maxRating = parseFloatOrDefault(max, 5f);
        return averageRatingRepository.findRestaurantsByDistinctAndRating(distinct,minRating,maxRating);
    }

    public List<AverageRating> getRestaurantBYTypeAndRatingAndDistinct
            (Set<String> type, String min, String max, Set<String> distinct) {
        Float minRating = parseFloatOrDefault(min, 0f);
        Float maxRating = parseFloatOrDefault(max, 5f);
        return averageRatingRepository.findRestaurantsByTypesAndRatingAndDistinct
                (type, minRating, maxRating, distinct);
    }

    public EachRestaurantFullInfoDto restaurantFullInfo(String restaurantUrl) {
        Restaurant restaurant = restaurantRepository.findByRestaurantUrl(restaurantUrl).get();
        List<CommentDto> commentsByRestaurant = ratingRepository.findCommentsByRestaurant(restaurant);
        List<Menu_Items> menuByRestaurant = menuRepository.getMenuByRestaurant(restaurant);
        AverageRating restaurantAverageRating = averageRatingRepository.findByRestaurant(restaurant);
        return new EachRestaurantFullInfoDto(restaurantAverageRating, menuByRestaurant, commentsByRestaurant);
    }

    public TopTen  getPopularAndTopRatingRestaurant(){
        List<AverageRating> topTenByRating = ratingRepository.getTopTen();
        List<AverageRating> topTenByBooking = bookingRepository.getTopTen();
        return new TopTen(topTenByRating,topTenByBooking);
    }

    public Set<AverageRating> getRecommendedRestaurant(String id) throws IOException {
        Long userID=Long.parseLong(id);
        Optional<Users> byId = userRepository.findById(userID);
        boolean exist = ratingRepository.isExist(userID);
        if(byId.isPresent()&&exist){
            List<Long> recommendation = recommendationService.Recommendation(userID);
            return averageRatingRepository.recommended(recommendation);
        }
        List<AverageRating> topTenByRating = ratingRepository.getTopTen();
        List<AverageRating> topTenByBooking = bookingRepository.getTopTen();
        Set<AverageRating> combinedSet = new TreeSet<>();
        combinedSet.addAll(topTenByRating);
        combinedSet.addAll(topTenByBooking);
        return combinedSet;
    }

    public boolean iseExist(String email) {
        return restaurantRepository.findByEmail(email).isPresent();
    }

    private Float parseFloatOrDefault(String value, Float defaultValue) {
        if (value != null) {
            return Float.parseFloat(value);
        }
        return defaultValue;
    }

}
