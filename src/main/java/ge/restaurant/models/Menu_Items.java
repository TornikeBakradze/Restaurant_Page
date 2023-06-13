package ge.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Menu")
public class Menu_Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long item_id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 2155)
    private String description ;

    @Column(nullable = false, length = 255)
    private String category;

    private Float price;

    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "restaurant_id")
    @JsonIgnore
    private Restaurant restaurant;

    public Menu_Items() {
    }

    public Menu_Items(Long item_id, String name,
                      String description, String category,
                      Float price, Restaurant restaurant) {
        this.item_id = item_id;
        this.name = name;
        this.description = description;
        this.category = category;
        this.price = price;
        this.restaurant = restaurant;
    }

    public void setId(Long id) {
        this.item_id = id;
    }

    public Long getId() {
        return item_id;
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

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
