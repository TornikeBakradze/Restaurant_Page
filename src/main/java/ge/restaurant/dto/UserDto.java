package ge.restaurant.dto;

public class UserDto {
    private Long id;
    private String email;
    private String userName;
    private String lastname;
    private String password;
    private String phoneNumber;
    private String street;
    private String streetNumber;
    private String district;

    private String role;

    public UserDto() {
    }

    public UserDto(Long id, String email, String userName, String lastname, String password, String phoneNumber, String street, String streetNumber, String district, String role) {
        this.id = id;
        this.email = email;
        this.userName = userName;
        this.lastname = lastname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.streetNumber = streetNumber;
        this.district = district;
        this.role = role;
    }

    public UserDto(String email, String userName,
                   String lastname, String password,
                   String phoneNumber, String street,
                   String streetNumber, String district,
                   String role) {
        this.email = email;
        this.userName = userName;
        this.lastname = lastname;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.streetNumber = streetNumber;
        this.district = district;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
