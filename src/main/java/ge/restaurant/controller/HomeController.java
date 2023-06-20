package ge.restaurant.controller;


import ge.restaurant.impl.RestaurantImpl;
import ge.restaurant.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/home")
@CrossOrigin("*")
public class HomeController {
    @Autowired
    private RestaurantImpl restaurant;

    @GetMapping("/")
    public Object user(@RequestParam(required = false) String id) throws IOException {
        if (id != null) {
            return restaurant.getRecommendedRestaurant(id);
        }
        return restaurant.getPopularAndTopRatingRestaurant();
    }
}
