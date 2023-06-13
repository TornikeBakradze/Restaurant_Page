package ge.restaurant.service;


import ge.restaurant.dto.UserDto;
import ge.restaurant.models.Users;
import ge.restaurant.exception.DataAlreadyExistException;


public interface UserService {
    Users register(UserDto userDto) throws DataAlreadyExistException;

}
