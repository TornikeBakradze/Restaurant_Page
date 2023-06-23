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

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("/restaurant")
public class RatingController {

    @Autowired
    private RatingImpl ratingImpl;

    @PostMapping("/{restaurantUrl}/rating")
    public void addRating(@PathVariable("restaurantUrl") String restaurantUrl,
                          @RequestBody List<BasicRatingDto> basicRatingDtos) {
        for (BasicRatingDto basicRatingDto : basicRatingDtos) {
            ratingImpl.AddRating(restaurantUrl, basicRatingDto.getServiceRating(),
                    basicRatingDto.getFoodRating(), basicRatingDto.getPriceRating(),
                    basicRatingDto.getAmbienceRating(), basicRatingDto.getUserid(),basicRatingDto.getComment());
        }
    }
}
