package ge.restaurant.service;


import ge.restaurant.dto.UserDto;
import ge.restaurant.models.Users;
import ge.restaurant.exception.DataAlreadyExistException;

import java.util.List;


public interface UserService {
    List<Users> register(List<UserDto> userDto) throws DataAlreadyExistException;

}
