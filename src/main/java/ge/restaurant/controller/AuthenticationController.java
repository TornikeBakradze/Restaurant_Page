package ge.restaurant.controller;

import ge.restaurant.dto.*;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.impl.LoginImpl;
import ge.restaurant.impl.RestaurantImpl;
import ge.restaurant.impl.UserImpl;
import ge.restaurant.models.Restaurant;
import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private UserImpl userImpl;

    @Autowired
    private RestaurantImpl restaurant;

    @Autowired
    private LoginImpl login;

    @Autowired
    private RestaurantRepository restaurantRepository;

    @PostMapping("/user-SingUp")
    public Object register(@RequestBody UserDto userDto) {
        try {
            return userImpl.register(userDto);
        } catch (DataAlreadyExistException e) {
            return e.getMessage();
        }
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDto longinDto) {
        try {
            LoginResponseDto responseDto = login.login(longinDto);
            return ResponseEntity.ok(responseDto);
        } catch (AuthenticationException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid email or password");
        }
    }

    @PostMapping("/rest-SingUp")
    public Object register(@RequestBody RestaurantDto restaurantDto) {
        try {
            return restaurant.register(restaurantDto);
        } catch (DataAlreadyExistException e) {
            return e.getMessage();
        }
    }

}
