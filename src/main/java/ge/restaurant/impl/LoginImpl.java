package ge.restaurant.impl;

import ge.restaurant.dto.LoginDto;
import ge.restaurant.dto.LoginResponseDto;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.models.Restaurant;
import ge.restaurant.models.Users;
import ge.restaurant.repository.RestaurantRepository;
import ge.restaurant.repository.UserRepository;
import ge.restaurant.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class LoginImpl {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;


    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    public Optional<Users> iseUserExist(String email) {
        return userRepository.findByEmail(email);
    }

    public Optional<Restaurant> iseRestExist(String email) {
        return restaurantRepository.findByEmail(email);
    }

    public LoginResponseDto login(LoginDto loginDto) throws AuthenticationException{

        try {
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword())
            );

            String token = tokenService.generateJwt(auth);
            if (iseRestExist(loginDto.getEmail()).isPresent()) {
                System.out.println(iseRestExist(loginDto.getEmail()).get());
                return new LoginResponseDto(iseRestExist(loginDto.getEmail()).get(), token);
            } else {
                return new LoginResponseDto(iseUserExist(loginDto.getEmail()).get(), token);
            }
        } catch (AuthenticationException e) {
            throw e;
        }
    }
}


