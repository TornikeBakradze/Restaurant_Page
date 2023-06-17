package ge.restaurant.models;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "restaurant")
public class Restaurant implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "restaurant_id")
    private Long restaurant_id;

    @Column(name = "email", nullable = false, length = 255, unique = true)
    private String email;

    @Column(name = "username", nullable = false, length = 255,unique = false)
    private String username;

    @Column(name = "type", nullable = false, length = 255)
    private String type;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false, length = 255)
    @JsonIgnore
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "restaurant_role_junction",
            joinColumns = {@JoinColumn(name = "restaurant_id")},
            inverseJoinColumns = {@JoinColumn(name = "role_id")}
    )
    private Set<Role> authorities;


    @ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "address_id")
    private Addresses addresses;

    @Column(unique = true)
    private String restaurantUrl;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "restaurantImage",
            joinColumns = {@JoinColumn(name = "restaurant_id")},
            inverseJoinColumns = {@JoinColumn(name = "image_id")}
    )
    private List<ImageData> images = new ArrayList<>();


    public Restaurant() {
    }

    public Restaurant(Long restaurant_id, String email,
                      String username, String type,
                      String phoneNumber, String password,
                      Set<Role> authorities,
                      Addresses addresses) {
        this.restaurant_id = restaurant_id;
        this.email = email;
        this.username = username;
        this.type = type;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.authorities = authorities;
        this.addresses = addresses;
        this.restaurantUrl = username.replaceAll("\\s","")+"_"+addresses.getStreet().replaceAll("\\s","")+"_"+addresses.getStreet_number().replaceAll("\\s","");
    }

    public List<ImageData> getImages() {
        return images;
    }

    public void setImages(List<ImageData> images) {
        this.images = images;
    }

    public Long getRestaurant_id() {
        return restaurant_id;
    }

    public void setRestaurant_id(Long restaurant_id) {
        this.restaurant_id = restaurant_id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(Set<Role> authorities) {
        this.authorities = authorities;
    }

    public Addresses getAddresses() {
        return addresses;
    }

    public void setAddresses(Addresses addresses) {
        this.addresses = addresses;
    }

    public String getRestaurantUrl() {
        return restaurantUrl;
    }

    public void setRestaurantUrl(String restaurantUrl) {
        this.restaurantUrl = restaurantUrl;
    }

    @Override
    public Set<Role> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "restaurant_id=" + restaurant_id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", type='" + type + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", password='" + password + '\'' +
                ", authorities=" + authorities +
                ", addresses=" + addresses +
                ", restaurantUrl='" + restaurantUrl + '\'' +
                '}';
    }
}
