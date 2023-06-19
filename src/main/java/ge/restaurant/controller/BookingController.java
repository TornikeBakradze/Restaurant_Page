package ge.restaurant.controller;

import ge.restaurant.dto.BookingDto;
import ge.restaurant.impl.BookingImpl;
import ge.restaurant.models.Booking;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/booking")
@CrossOrigin("*")
public class BookingController {
    @Autowired
    private BookingImpl booking;

    @PostMapping("/addVisit/{restaurantUrl}")
    public Booking addVisit(@RequestBody BookingDto bookingDto,
                            @PathVariable("restaurantUrl") String restaurantUrl) {
        return booking.addVisit(bookingDto, restaurantUrl);
    }

    @GetMapping("/{restaurantUrl}")
    public List<Booking> restaurantAllBooking(@PathVariable("restaurantUrl") String restaurantUrl){
        return booking.restaurantAllBooking(restaurantUrl);
    }

    @GetMapping("/CustomerReservations")
    private List<Booking> usersAllBooking(@RequestParam String id){
        Long idd=Long.parseLong(id);
        return booking.userAllBooking(idd);
    }
}
