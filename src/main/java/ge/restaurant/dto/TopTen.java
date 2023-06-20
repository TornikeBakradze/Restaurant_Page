package ge.restaurant.dto;

import ge.restaurant.models.AverageRating;


import java.util.List;

public class TopTen {
    private List<AverageRating> byRating;
    private List<AverageRating> byBooking;

    public TopTen() {
    }

    public TopTen(List<AverageRating> averageRatingList, List<AverageRating> bookingList) {
        this.byRating = averageRatingList;
        this.byBooking = bookingList;
    }

    public List<AverageRating> getByRating() {
        return byRating;
    }

    public void setByRating(List<AverageRating> byRating) {
        this.byRating = byRating;
    }

    public List<AverageRating> getByBooking() {
        return byBooking;
    }

    public void setByBooking(List<AverageRating> byBooking) {
        this.byBooking = byBooking;
    }
}
