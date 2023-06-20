package ge.restaurant.repository;

import ge.restaurant.models.AverageRating;
import ge.restaurant.models.Booking;
import ge.restaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking,Long> {

    @Query("Select b from Booking b where b.restaurant.restaurant_id=:id")
    List<Booking> getAllVisit(Long id);

    @Query("Select b from Booking  b where b.users.user_id=:id")
    List<Booking> getAllBooking(Long id);

    @Query("SELECT DISTINCT r " +
            "FROM AverageRating r\n" +
            "INNER JOIN Booking b ON r.restaurant.restaurant_id = b.restaurant.restaurant_id \n" +
            "ORDER BY (SELECT COUNT(*) FROM Booking b WHERE" +
            " b.restaurant.restaurant_id = r.restaurant.restaurant_id) DESC\n" +
            "LIMIT 10")
    List<AverageRating> getTopTen();
}
