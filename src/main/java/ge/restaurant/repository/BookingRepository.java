package ge.restaurant.repository;

import ge.restaurant.models.Booking;
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
}
