package ge.restaurant.impl;

import ge.restaurant.dto.BookingDto;
import ge.restaurant.models.Booking;
import ge.restaurant.models.Restaurant;
import ge.restaurant.models.Users;
import ge.restaurant.repository.BookingRepository;
import ge.restaurant.repository.RestaurantRepository;
import ge.restaurant.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookingImpl {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RestaurantRepository restaurantRepository;
    @Autowired
    private UserRepository userRepository;

    public Booking addVisit(BookingDto bookingDto, String restaurantUrl) {
        Restaurant restaurant =
                restaurantRepository.findByRestaurantUrl(restaurantUrl).get();
        Users user = userRepository.findById(bookingDto.getUserId()).get();
        return bookingRepository.save(
                new Booking(0L, bookingDto.getDateOfReservation(),
                        bookingDto.getDateOfVisit(),bookingDto.getNumberOfPeople(),restaurant, user));
    }

    public List<Booking> restaurantAllBooking(String restaurantUrl) {
        Long restaurantId =
                restaurantRepository.findByRestaurantUrl
                        (restaurantUrl).get().getRestaurant_id();
        return bookingRepository.getAllVisit(restaurantId);
    }

    public List<Booking> userAllBooking(Long id){
        return bookingRepository.getAllBooking(id);
    }
}
