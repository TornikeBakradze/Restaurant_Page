package ge.restaurant.dto;

import ge.restaurant.models.AverageRating;

import java.util.List;
import java.util.Set;

public class RestaurantMainDto {
    private List<AverageRating> averageRatingList;

    private Set<String> types;

    private Set<String> district;
    public RestaurantMainDto() {
    }

    public RestaurantMainDto(List<AverageRating> averageRatingList, Set<String> types, Set<String> district) {
        this.averageRatingList = averageRatingList;
        this.types = types;
        this.district = district;
    }

    public Set<String> getDistrict() {
        return district;
    }

    public void setDistrict(Set<String> district) {
        this.district = district;
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
