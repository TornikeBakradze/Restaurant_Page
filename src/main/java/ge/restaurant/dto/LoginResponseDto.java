package ge.restaurant.dto;

import ge.restaurant.models.Restaurant;
import ge.restaurant.models.Users;

public class LoginResponseDto {
    private Users user;

    private Restaurant restaurant;

    private String jwt;

    public LoginResponseDto() {
    }

    public LoginResponseDto(Restaurant restaurant, String jwt) {
        this.restaurant = restaurant;
        this.jwt = jwt;
    }

    public LoginResponseDto(Users user, String jwt) {
        this.user = user;
        this.jwt = jwt;
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

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
