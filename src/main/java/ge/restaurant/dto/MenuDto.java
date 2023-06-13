package ge.restaurant.dto;

public class MenuDto {
    private String name;
    private String description ;
    private String category;
    private Float price;

    private Long restaurantID;

    public MenuDto() {
    }

    public MenuDto(String name, String description, String category, Float price, Long restaurantID) {
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.restaurantID = restaurantID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getRestaurantID() {
        return restaurantID;
    }

    public void setRestaurantID(Long restaurantID) {
        this.restaurantID = restaurantID;
    }
}
