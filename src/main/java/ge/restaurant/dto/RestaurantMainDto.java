package ge.restaurant.dto;

import ge.restaurant.models.AverageRating;

import java.util.List;
import java.util.Set;

public class RestaurantMainDto {
    private List<AverageRating> averageRatingList;

    private Set<String> types;

    public RestaurantMainDto() {
    }

    public RestaurantMainDto(List<AverageRating> averageRatingList, Set<String> types) {
        this.averageRatingList = averageRatingList;
        this.types = types;
    }

    public List<AverageRating> getAverageRatingList() {
        return averageRatingList;
    }

    public void setAverageRatingList(List<AverageRating> averageRatingList) {
        this.averageRatingList = averageRatingList;
    }

    public Set<String> getTypes() {
        return types;
    }

    public void setTypes(Set<String> types) {
        this.types = types;
    }
}
