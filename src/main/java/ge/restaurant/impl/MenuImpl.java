package ge.restaurant.impl;

import ge.restaurant.dto.MenuDto;
import ge.restaurant.exception.DataAlreadyExistException;
import ge.restaurant.models.Menu_Items;
import ge.restaurant.models.Restaurant;
import ge.restaurant.repository.MenuRepository;
import ge.restaurant.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MenuImpl {
    @Autowired
    private MenuRepository menuRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;

    public void add(List<MenuDto> menuDto) throws DataAlreadyExistException {
        Restaurant restaurant = restaurantRepository.findById(menuDto.get(0).getRestaurantID()).get();
        for (MenuDto dto : menuDto) {
            if(menuRepository.findByName(dto.getName())!=null)
                throw new DataAlreadyExistException("This menu already exist");
            ;
            Menu_Items menuItems = new Menu_Items(0L, dto.getName(),
                    dto.getDescription(), dto.getCategory(), dto.getPrice(), restaurant);
            menuRepository.save(menuItems);
        }
    }
}
