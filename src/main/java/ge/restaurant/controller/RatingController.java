package ge.restaurant.controller;

import ge.restaurant.dto.AddCommentDto;
import ge.restaurant.dto.BasicRatingDto;
import ge.restaurant.impl.RatingImpl;
import ge.restaurant.models.Rating;
import ge.restaurant.models.Restaurant;
import ge.restaurant.models.Users;
import ge.restaurant.repository.RatingRepository;
import ge.restaurant.repository.RestaurantRepository;
import ge.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@CrossOrigin("*")
@RequestMapping("/restaurant")
public class RatingController {

    @Autowired
    private RatingImpl ratingImpl;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private RatingRepository ratingRepository;


    @PostMapping("/{restaurantUrl}/rating")
    public void addRating(@PathVariable("restaurantUrl") String restaurantUrl,
                          @RequestBody BasicRatingDto basicRatingDto) {
        if (basicRatingDto.getAmbienceRating() == -1) {
            ratingImpl.AddRating(restaurantUrl, basicRatingDto.getUserGeneralRating(), basicRatingDto.getUserid());
        } else {
            ratingImpl.AddRating(restaurantUrl, basicRatingDto.getServiceRating(),
                    basicRatingDto.getFoodRating(), basicRatingDto.getPriceRating(),
                    basicRatingDto.getAmbienceRating(), basicRatingDto.getUserid());
        }
    }

    @PostMapping("/{restaurantUrl}/comm")
    public void addComme(@PathVariable("restaurantUrl") String restaurantUrl, @RequestBody AddCommentDto addCommentDto) {
        Restaurant restaurant = restaurantRepository.findByRestaurantUrl(restaurantUrl).get();
        Users users = userRepository.findById(addCommentDto.getUserId()).get();
        ratingRepository.save(new Rating(restaurant, users, addCommentDto.getComment()));
    }


}
