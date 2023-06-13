package ge.restaurant.service;

import ge.restaurant.models.Rating;
import ge.restaurant.models.Restaurant;
import ge.restaurant.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

@Service
public class RestaurantGeneralRatingService {

    @Autowired
    private RatingRepository ratingRepository;

    public Float updatedGeneralRating(Restaurant restaurant,Float newRating){
        int row=ratingRepository.countRowsWithCommentNullAndUserIdNotOne(restaurant);
        if(row==0){
            return newRating;
        }
        return ((ratingRepository.averageRatingBy(restaurant)*row)+newRating)/(row+1);
    }

    public Map<String,Float> updatedBasicRating(Restaurant restaurant, Float newFoodRating, Float newServiceRating,
                                                Float newAmbianceRating, Float newPriceRating){
        int row=ratingRepository.averageRatingRow(restaurant);
        Map<String,Float> updatedRatings=new HashMap<>();
        if(row==0){
            updatedRatings.put("FootRating",newFoodRating);
            updatedRatings.put("ServiceRating",newServiceRating);
            updatedRatings.put("AmbianceRating",newAmbianceRating);
            updatedRatings.put("PriceRating",newPriceRating);
            return updatedRatings;
        }
        Float updatedFoodRT=((ratingRepository.averageFoodRating(restaurant)*row)+newFoodRating)/(row+1);
        Float updatedServiceRT=((ratingRepository.averageServiceRating(restaurant)*row)+newServiceRating)/(row+1);
        Float updatedAmbianceRT=((ratingRepository.averageAmbienceRating(restaurant)*row)+newAmbianceRating)/(row+1);
        Float updatedPriceRT=((ratingRepository.averagePriceRating(restaurant)*row)+newPriceRating)/(row+1);
        updatedRatings.put("FootRating",updatedFoodRT);
        updatedRatings.put("ServiceRating",updatedServiceRT);
        updatedRatings.put("AmbianceRating",updatedAmbianceRT);
        updatedRatings.put("PriceRating",updatedPriceRT);
        return updatedRatings;
    }
}
