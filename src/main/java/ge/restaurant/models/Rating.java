package ge.restaurant.models;


import jakarta.persistence.*;

@Entity
@Table(name = "Ratings")
public class Rating {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rating_id")
    private Long ratingId;


    @ManyToOne
    @JoinColumn(name = "restaurant_id", referencedColumnName = "restaurant_id")
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Users user;

    @Column(name = "general_rating")
    private Float generalRating;


    @Column(name = "comment", length = 2255)
    private String comment;

    @Column(name = "service_rating")
    private Float serviceRating;

    @Column(name = "food_rating")
    private Float foodRating;

    @Column(name = "price_rating")
    private Float priceRating;

    @Column(name = "ambience_rating")
    private Float ambienceRating;


    public Rating() {
    }

    public Rating(Restaurant restaurant, Users user, Float generalRating) {
        this.restaurant = restaurant;
        this.user = user;
        this.generalRating = generalRating;
    }

    public Rating(Restaurant restaurant, Users user, String comment) {
        this.restaurant = restaurant;
        this.user = user;
        this.comment = comment;
    }

    public Rating(Restaurant restaurant, Users user,
                  Float serviceRating, Float foodRating,
                  Float priceRating, Float ambienceRating) {
        this.restaurant = restaurant;
        this.user = user;
        this.generalRating=(serviceRating+foodRating+priceRating+ambienceRating)/4;
        this.serviceRating = serviceRating;
        this.foodRating = foodRating;
        this.priceRating = priceRating;
        this.ambienceRating = ambienceRating;
    }

    public Rating(Restaurant restaurant, Users user,
                  Float generalRating, String comment,
                  Float serviceRating, Float foodRating,
                  Float priceRating, Float ambienceRating) {
        this.restaurant = restaurant;
        this.user = user;
        this.generalRating = generalRating;
        this.comment = comment;
        this.serviceRating = serviceRating;
        this.foodRating = foodRating;
        this.priceRating = priceRating;
        this.ambienceRating = ambienceRating;
    }

    public Long getRatingId() {
        return ratingId;
    }

    public void setRatingId(Long ratingId) {
        this.ratingId = ratingId;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Float getGeneralRating() {
        return generalRating;
    }

    public void setGeneralRating(Float generalRating) {
        this.generalRating = generalRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Float getServiceRating() {
        return serviceRating;
    }

    public void setServiceRating(Float serviceRating) {
        this.serviceRating = serviceRating;
    }

    public Float getFoodRating() {
        return foodRating;
    }

    public void setFoodRating(Float foodRating) {
        this.foodRating = foodRating;
    }

    public Float getPriceRating() {
        return priceRating;
    }

    public void setPriceRating(Float priceRating) {
        this.priceRating = priceRating;
    }

    public Float getAmbienceRating() {
        return ambienceRating;
    }

    public void setAmbienceRating(Float ambienceRating) {
        this.ambienceRating = ambienceRating;
    }
}