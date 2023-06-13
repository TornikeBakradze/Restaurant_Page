package ge.restaurant.impl;

import ge.restaurant.dto.MenuDto;
import ge.restaurant.models.Menu_Items;
import ge.restaurant.models.Restaurant;
import ge.restaurant.repository.MenuRepository;
import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MenuImpl {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void add(MenuDto menuDto){
        Restaurant restaurant = restaurantRepository.findById(menuDto.getRestaurantID()).get();
        Menu_Items menuItems = new Menu_Items(0L, menuDto.getName(),
                menuDto.getDescription(), menuDto.getCategory(), menuDto.getPrice(), restaurant);
        menuRepository.save(menuItems);
    }
}
