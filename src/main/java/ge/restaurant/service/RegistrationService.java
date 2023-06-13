package ge.restaurant.service;

import ge.restaurant.models.Addresses;
import ge.restaurant.models.Role;
import ge.restaurant.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class RegistrationService {

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

    public String encodePassword(String password) {
        return passwordEncoder.encode(password);
    }

    public Set<Role> role(String rolee) {
        Role userRole = roleRepository.findByAuthority(rolee).get();
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);
        return roles;
    }

    public Set<Addresses> addresses(String street, String streetNumber,String district) {
        Addresses addresses = new Addresses(street, streetNumber,district);
        Set<Addresses> addressesSet = new HashSet<>();
        addressesSet.add(addresses);
        return addressesSet;
    }
}
