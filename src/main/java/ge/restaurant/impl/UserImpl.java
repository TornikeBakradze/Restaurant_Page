package ge.restaurant.impl;


import ge.restaurant.dto.UserDto;
import ge.restaurant.models.Addresses;
import ge.restaurant.models.Role;
import ge.restaurant.models.Users;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.repository.UserRepository;
import ge.restaurant.service.RegistrationService;
import ge.restaurant.service.TokenService;
import ge.restaurant.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;

@Service
@Transactional
public class UserImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RegistrationService registrationService;


    @Override
    public Users register(UserDto userDto) throws DataAlreadyExistException {
        if (iseExist(userDto.getEmail())) {
            throw new DataAlreadyExistException("This Email is already used");
        }

        String encPass = registrationService.encodePassword(userDto.getPassword());
        Set<Role> roles = registrationService.role(userDto.getRole());
        Set<Addresses> addressesSet =
                registrationService.addresses(userDto.getStreet(), userDto.getStreetNumber(),userDto.getDistrict());

        return userRepository.save(new Users(0L, userDto.getEmail(),
                userDto.getUserName(), userDto.getLastname(),
                userDto.getPhoneNumber(), encPass, roles, addressesSet));
    }

    public Users update(UserDto userDto) throws Exception {
        Users users = userRepository.findById(userDto.getId()).orElse(null);
        if(users!=null){
            users.setUsername(userDto.getUserName());
            users.setEmail(userDto.getEmail());
            users.setLastname(userDto.getLastname());
            users.setPhoneNumber(userDto.getPhoneNumber());
            String encPass=registrationService.encodePassword(userDto.getPassword());
            users.setPassword(encPass);
            Set<Addresses> addressesSet =
                    registrationService.addresses
                            (userDto.getStreet(), userDto.getStreetNumber(),userDto.getDistrict());
            users.setAddresses(addressesSet);
            return userRepository.save(users);
        }
        throw  new Exception("Something went wrong");
    }

    public boolean iseExist(String email) {
        return userRepository.findByEmail(email).isPresent();
    }
}
