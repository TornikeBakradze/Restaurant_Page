package ge.restaurant.dto;

import ge.restaurant.models.AverageRating;


import java.util.List;
import java.util.Set;

public class TopTen {
    private List<AverageRating> byRating;
    private List<AverageRating> byBooking;
    private Set<AverageRating> recommendation;

    public TopTen() {
    }

    public TopTen(List<AverageRating> averageRatingList, List<AverageRating> bookingList, Set<AverageRating> recommendation) {
        this.byRating = averageRatingList;
        this.byBooking = bookingList;
        this.recommendation = recommendation;
    }

    public Set<AverageRating> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Set<AverageRating> recommendation) {
        this.recommendation = recommendation;
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
