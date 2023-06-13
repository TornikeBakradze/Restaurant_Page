package ge.restaurant.impl;

import ge.restaurant.models.Rating;
import ge.restaurant.models.Restaurant;
import ge.restaurant.models.Users;
import ge.restaurant.repository.AverageRatingRepository;
import ge.restaurant.repository.RatingRepository;
import ge.restaurant.repository.RestaurantRepository;
import ge.restaurant.repository.UserRepository;
import ge.restaurant.service.RatingService;
import ge.restaurant.service.RestaurantGeneralRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@Transactional
public class RatingImpl implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;
    @Autowired
    private RestaurantGeneralRatingService restaurantGeneralRatingService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private AverageRatingRepository averageRatingRepository;

    @Override
    public void AddRating(String restaurantName, Float rating, Long id) {
        Restaurant restaurant = restaurantRepository.findByRestaurantUrl(restaurantName).get();
        Users user = userRepository.findById(id).get();
        Rating rating1 = new Rating(restaurant, user, rating);
        Float aFloat = newAverageRating(restaurant,rating);
        averageRatingRepository.updateAverageRating(aFloat, restaurant);
        ratingRepository.save(rating1);
    }

    public Float newAverageRating(Restaurant restaurant, Float rating) {
        return restaurantGeneralRatingService.updatedGeneralRating(restaurant, rating);
    }

    public void AddRating(String restaurantName, Float serviceRating,
                          Float foodRating, Float priceRating,
                          Float ambienceRating, Long id) {
        Restaurant restaurant = restaurantRepository.findByRestaurantUrl(restaurantName).get();
        Map<String, Float> updatedRating = restaurantGeneralRatingService
                .updatedBasicRating(restaurant, foodRating, serviceRating,
                        ambienceRating, priceRating);
        Users user = userRepository.findById(id).get();
        Rating rating1 = new Rating(restaurant, user, serviceRating, foodRating, priceRating, ambienceRating);
        Float newAverageRating = newAverageRating(restaurant,rating1.getGeneralRating());
        averageRatingRepository
                .updateAverageRatingsExceptAverageRating(updatedRating.get("ServiceRating"),
                        updatedRating.get("FootRating"), updatedRating.get("PriceRating"),
                        updatedRating.get("AmbianceRating"), newAverageRating, restaurant);
        ratingRepository.save(rating1);
    }

}
