package ge.restaurant.dto;

public class BasicRatingDto {
    private Float userGeneralRating;
    private Float serviceRating;
    private Float foodRating;
    private Float priceRating;
    private Float ambienceRating;
    private Long userid;

    public BasicRatingDto() {
    }

    public BasicRatingDto(Float userGeneralRating, Float serviceRating,
                          Float foodRating, Float priceRating, Float ambienceRating,
                          Long userid) {
        this.userGeneralRating = userGeneralRating;
        this.serviceRating = serviceRating;
        this.foodRating = foodRating;
        this.priceRating = priceRating;
        this.ambienceRating = ambienceRating;
        this.userid = userid;
    }

    public Float getUserGeneralRating() {
        return userGeneralRating;
    }

    public void setUserGeneralRating(Float userGeneralRating) {
        this.userGeneralRating = userGeneralRating;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUser(Long user) {
        this.userid = user;
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

    public void setUserid(Long userid) {
        this.userid = userid;
    }
}
