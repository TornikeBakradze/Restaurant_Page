package ge.restaurant.dto;


import java.time.LocalDateTime;

public class BookingDto {
    private Long userId;
    private LocalDateTime dateOfReservation;
    private LocalDateTime dateOfVisit;

    private int numberOfPeople;

    public BookingDto() {
    }

    public BookingDto(Long userId, LocalDateTime dateOfReservation,
                      LocalDateTime dateOfVisit, int numberOfPeople) {
        this.userId = userId;
        this.dateOfReservation = dateOfReservation;
        this.dateOfVisit = dateOfVisit;
        this.numberOfPeople = numberOfPeople;
    }

    public Long getUserId() {
        return userId;
    }

    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        this.numberOfPeople = numberOfPeople;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
}
