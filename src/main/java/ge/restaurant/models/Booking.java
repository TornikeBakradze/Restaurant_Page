package ge.restaurant.models;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "Booking")
public class Booking {
    @Id
    @Column(name = "booking_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name = "Date_of_reservation")
    private LocalDateTime dateOfReservation;

    @Column(name = "Date_of_visit")
    private LocalDateTime dateOfVisit;

    private int numberOfPeople;

    @ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    public Booking() {
    }

    public Booking(Long bookingId, LocalDateTime dateOfReservation,
                   LocalDateTime dateOfVisit, int numberOfPeople,
                   Restaurant restaurant, Users users) {
        this.bookingId = bookingId;
        this.dateOfReservation = dateOfReservation;
        this.dateOfVisit = dateOfVisit;
        this.numberOfPeople = numberOfPeople;
        this.restaurant = restaurant;
        this.users = users;
    }

    public LocalDateTime getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(LocalDateTime dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public LocalDateTime getDateOfVisit() {
        return dateOfVisit;
    }

    public void setDateOfVisit(LocalDateTime dateOfVisit) {
        this.dateOfVisit = dateOfVisit;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public void setBookingId(Long bookingId) {
        this.bookingId = bookingId;
    }

    public Long getBookingId() {
        return bookingId;
    }
}
