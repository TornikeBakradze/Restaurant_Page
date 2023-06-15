package ge.restaurant.controller;

import ge.restaurant.dto.*;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.impl.LoginImpl;
import ge.restaurant.impl.RestaurantImpl;
import ge.restaurant.impl.UserImpl;
import ge.restaurant.models.Restaurant;
import ge.restaurant.models.Users;
import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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
    public List<Users> register(@RequestBody List<UserDto> userDto) throws DataAlreadyExistException {
        return userImpl.register(userDto);
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
    public List<Restaurant> registers(@RequestBody List<RestaurantDto> restaurantDto) throws DataAlreadyExistException {
            return restaurant.register(restaurantDto);

    }

}
