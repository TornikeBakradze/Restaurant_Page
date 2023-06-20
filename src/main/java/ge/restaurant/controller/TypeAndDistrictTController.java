package ge.restaurant.controller;

import ge.restaurant.dto.TypeAndDistrict;
import ge.restaurant.impl.RestaurantImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/typeAndDistrict")
@CrossOrigin("*")
public class TypeAndDistrictTController {
    @Autowired
    private RestaurantImpl restaurant;
    @GetMapping("/")
    public TypeAndDistrict gettypeAndDistrict(){
        return restaurant.getAllTypeAndDistrict();
    }
}
