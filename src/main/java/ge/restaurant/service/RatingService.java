package ge.restaurant.service;

import ge.restaurant.models.Restaurant;

public interface RatingService {
    void AddRating(String restaurantName, Float rating, Long id);
}
