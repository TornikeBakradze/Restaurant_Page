package ge.restaurant.repository;

import ge.restaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long> {
    Optional<Restaurant> findByEmail(String email);

    @Query("SELECT r FROM Restaurant r WHERE r.restaurantUrl = :url")
    Optional<Restaurant> findByRestaurantUrl(@Param("url") String url);

    @Query("SELECT DISTINCT r.type FROM Restaurant r")
    Set<String> findAllUniqueTypes();

    @Query("Select distinct r.addresses.district from Restaurant r")
    Set<String> getAllUniqueDistinct();
}
