package ge.restaurant.controller;

import ge.restaurant.dto.UserDto;
import ge.restaurant.impl.UserImpl;
import ge.restaurant.models.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserImpl user;
    @PostMapping("/EditProfile")
    public Users update(@RequestBody UserDto userDto) throws Exception {
        System.out.println("helo");
        return user.update(userDto);
    }
}
