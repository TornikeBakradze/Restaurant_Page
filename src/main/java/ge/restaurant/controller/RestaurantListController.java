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
            @RequestParam(required = false) String max){
        if(type!=null&&(min!=null||max!=null)){
            return restaurant.getRestaurantByTypeAndRating(type,min,max);
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
