package ge.restaurant.controller;


import ge.restaurant.dto.EachRestaurantFullInfoDto;
import ge.restaurant.impl.RestaurantImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin("*")
public class RestaurantListController {

    @Autowired
    private RestaurantImpl restaurant;


    @GetMapping("/")
    public Object getAllRestaurant(
            @RequestParam(required = false) Set<String> type,
            @RequestParam(required = false) String min,
            @RequestParam(required = false) String max,
            @RequestParam(required = false) Set<String> district){
        if(type!=null&&(min!=null||max!=null)&&district!=null){
            return restaurant.getRestaurantBYTypeAndRatingAndDistinct(type,min,max,district);
        }
        if(type!=null&&(min!=null||max!=null)){
            return restaurant.getRestaurantByTypeAndRating(type,min,max);
        }
        if(type!=null&&district!=null){
            return restaurant.getRestaurantByTypeAndDistinct(type,district);
        }
        if(district!=null&&(min!=null||max!=null)){
            return restaurant.getRestaurantByDistinctAndRating(district,min,max);
        }
        if(district!=null){
            return restaurant.getRestaurantByDistrict(district);
        }
        if(type!=null){
            return restaurant.getRestaurantByType(type);
        }
        if(min!=null||max!=null){
            return restaurant.getRestaurantByRating(min,max);
        }
        return restaurant.getAllRestaurant();
    }

    @GetMapping("/{restaurantUrl}")
    public EachRestaurantFullInfoDto restaurantFullInfo(@PathVariable("restaurantUrl")String restaurantUrl){
        return restaurant.restaurantFullInfo(restaurantUrl);
    }
}
