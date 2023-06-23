package ge.restaurant.dto;

import org.springframework.web.multipart.MultipartFile;

public class ManuImageUploaderDto {
    private String restaurantID;
    private String foodName;
    private MultipartFile image;

    public ManuImageUploaderDto() {
    }

    public ManuImageUploaderDto(String restaurantID, String foodName, MultipartFile image) {
        this.restaurantID = restaurantID;
        this.foodName = foodName;
        this.image = image;
    }

    public String getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(String restaurantID) {
        this.restaurantID = restaurantID;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public MultipartFile getImage() {
        return image;
    }

    public void setImage(MultipartFile image) {
        this.image = image;
    }
}
