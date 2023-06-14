package ge.restaurant.controller;

import ge.restaurant.dto.CommentDto;
import ge.restaurant.dto.MenuDto;
import ge.restaurant.impl.MenuImpl;
import ge.restaurant.models.Menu_Items;
import ge.restaurant.models.Restaurant;
import ge.restaurant.repository.MenuRepository;
import ge.restaurant.repository.RatingRepository;
import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class MenuController {
    @Autowired
    private MenuImpl menu;
    @PostMapping("/addMenu")
    public String add(@RequestBody List<MenuDto> menuDto) {
        menu.add(menuDto);
        return "Saved";
    }
}
