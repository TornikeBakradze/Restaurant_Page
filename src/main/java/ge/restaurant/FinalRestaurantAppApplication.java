package ge.restaurant;

import ge.restaurant.models.Addresses;
import ge.restaurant.models.Role;
import ge.restaurant.models.Users;
import ge.restaurant.repository.RoleRepository;
import ge.restaurant.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class FinalRestaurantAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinalRestaurantAppApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        return args -> {
            if(roleRepository.findByAuthority("ADMIN").isPresent()) return;
            Role adminRole = roleRepository.save(new Role("ADMIN"));
            roleRepository.save(new Role("USER"));
            roleRepository.save(new Role("RESTAURANT"));

            Set<Role> roles = new HashSet<>();
            roles.add(adminRole);

            Addresses addresses=new Addresses("Chavchavadze","1","Vake");
            Set<Addresses> addressesSet=new HashSet<>();
            addressesSet.add(addresses);

            Users admin = new Users(1L, "admin@gmail.com","admin","admin1",
                    "571228434",
                    passwordEncoder.encode("password"),
                    roles,addressesSet);
            userRepository.save(admin);
        };
    }
}
