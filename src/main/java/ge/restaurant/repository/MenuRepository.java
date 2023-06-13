package ge.restaurant.repository;

import ge.restaurant.models.Menu_Items;
import ge.restaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends JpaRepository<Menu_Items,Long> {
    @Query("Select m from Menu_Items m where m.name=:name")
    Menu_Items findByName(@Param("name")String name);

    @Query("Select m from Menu_Items m where m.restaurant=:restaurant")
    List<Menu_Items> getMenuByRestaurant(Restaurant restaurant);
}
