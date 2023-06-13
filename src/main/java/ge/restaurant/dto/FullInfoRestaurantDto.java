package ge.restaurant.dto;

import ge.restaurant.models.Menu_Items;
import ge.restaurant.models.Restaurant;

import java.util.List;

public class FullInfoRestaurantDto {
    private Restaurant restaurant;
    private Float rating;

    private List<String> comment;

    private List<Menu_Items> menuItems;

    public FullInfoRestaurantDto() {
    }

    public FullInfoRestaurantDto(Restaurant restaurant, Float rating,
                                 List<String> comment, List<Menu_Items> menuItems) {
        this.restaurant = restaurant;
        this.rating = rating;
        this.comment = comment;
        this.menuItems = menuItems;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public List<String> getComment() {
        return comment;
    }

    public void setComment(List<String> comment) {
        this.comment = comment;
    }

    public List<Menu_Items> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<Menu_Items> menuItems) {
        this.menuItems = menuItems;
    }
}
