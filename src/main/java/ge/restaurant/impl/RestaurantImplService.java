package ge.restaurant.impl;

import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("restaurantDetailsService")
public class RestaurantImplService implements UserDetailsService {
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        System.out.println("In the restaurant details service");
        return restaurantRepository.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Restaurant dont exist"));
    }
}
