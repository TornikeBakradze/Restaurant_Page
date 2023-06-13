package ge.restaurant.service;


import ge.restaurant.dto.RestaurantDto;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.models.Restaurant;

import java.util.List;


public interface RestaurantService {
    Restaurant register(RestaurantDto restaurantDto) throws DataAlreadyExistException;
}
