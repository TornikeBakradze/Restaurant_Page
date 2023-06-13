package ge.restaurant.models;

import jakarta.persistence.*;

@Entity
@Table(name = "AverageRating")
public class AverageRating {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "averageRating_Id")
    private Long averageRating_Id;

    private Float averageRating;
    private Float averageServiceRating;
    private Float averageFoodRating;
    private Float averagePriceRating;
    private Float averageAmbienceRating;

    @OneToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

    public AverageRating() {
    }

    public AverageRating(Float averageRating, Float averageServiceRating,
                         Float averageFoodRating, Float averagePriceRating,
                         Float averageAmbienceRating, Restaurant restaurant) {
        this.averageRating = averageRating;
        this.averageServiceRating = averageServiceRating;
        this.averageFoodRating = averageFoodRating;
        this.averagePriceRating = averagePriceRating;
        this.averageAmbienceRating = averageAmbienceRating;
        this.restaurant = restaurant;
    }

    public AverageRating(Float averageRating, Restaurant restaurant) {
        this.averageRating = averageRating;
        this.restaurant = restaurant;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Float getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(Float averageRating) {
        this.averageRating = averageRating;
    }

    public Float getAverageServiceRating() {
        return averageServiceRating;
    }

    public void setAverageServiceRating(Float averageServiceRating) {
        this.averageServiceRating = averageServiceRating;
    }

    public Float getAverageFoodRating() {
        return averageFoodRating;
    }

    public void setAverageFoodRating(Float averageFoodRating) {
        this.averageFoodRating = averageFoodRating;
    }

    public Float getAveragePriceRating() {
        return averagePriceRating;
    }

    public void setAveragePriceRating(Float averagePriceRating) {
        this.averagePriceRating = averagePriceRating;
    }

    public Float getAverageAmbienceRating() {
        return averageAmbienceRating;
    }

    public void setAverageAmbienceRating(Float averageAmbienceRating) {
        this.averageAmbienceRating = averageAmbienceRating;
    }

    public void setAverageRating_Id(Long averageRatingId) {
        this.averageRating_Id = averageRatingId;
    }

    public Long getAverageRating_Id() {
        return averageRating_Id;
    }
}
