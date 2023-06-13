package ge.restaurant.dto;

import ge.restaurant.models.AverageRating;
import ge.restaurant.models.Menu_Items;

import java.util.List;

public class EachRestaurantFullInfoDto {
    private AverageRating averageRating;
    private List<Menu_Items> menuItemsList;
    private List<CommentDto> comment;

    public EachRestaurantFullInfoDto() {
    }

    public EachRestaurantFullInfoDto(AverageRating averageRating, List<Menu_Items> menuItemsList,
                                     List<CommentDto> comment) {
        this.averageRating = averageRating;
        this.menuItemsList = menuItemsList;
        this.comment = comment;
    }

    public AverageRating getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(AverageRating averageRating) {
        this.averageRating = averageRating;
    }

    public List<Menu_Items> getMenuItemsList() {
        return menuItemsList;
    }

    public void setMenuItemsList(List<Menu_Items> menuItemsList) {
        this.menuItemsList = menuItemsList;
    }

    public List<CommentDto> getComment() {
        return comment;
    }

    public void setComment(List<CommentDto> comment) {
        this.comment = comment;
    }
}
