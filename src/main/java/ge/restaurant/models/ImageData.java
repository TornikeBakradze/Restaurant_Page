package ge.restaurant.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "Image")
public class ImageData {
    @Id
    @Column(name = "image_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Long imageID;

    private String url;
    @JsonIgnore
    private String name;
    @JsonIgnore
    private String type;
    @JsonIgnore
    private String filePath;


    public ImageData() {
    }

    public ImageData(String name, String type, String filePath) {
        this.imageID = imageID;
        this.url = "/image/" + name;
        this.name = name;
        this.type = type;
        this.filePath = filePath;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public void setImageID(Long imageID) {
        this.imageID = imageID;
    }

    public Long getImageID() {
        return imageID;
    }
}
