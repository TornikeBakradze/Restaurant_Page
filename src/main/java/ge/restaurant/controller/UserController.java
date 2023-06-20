package ge.restaurant.controller;

import ge.restaurant.dto.UserDto;
import ge.restaurant.impl.RatingImpl;
import ge.restaurant.impl.UserImpl;
import ge.restaurant.models.Rating;
import ge.restaurant.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserImpl user;
    @Autowired
    private RatingImpl rating;
    @PostMapping("/EditProfile")
    public Users update(@RequestBody UserDto userDto) throws Exception {
        return user.update(userDto);
    }

    @GetMapping("/userActivity")
    public List<Rating> getUserActivity(@RequestParam String id){
        return rating.getUserActivity(id);
    }
}
