package ge.restaurant.dto;

import ge.restaurant.models.Users;

public class CommentDto {
    private String comment;
    private Users users;
    private Float generalRating;

    public CommentDto() {
    }

    public CommentDto(String comment, Users users, Float generalRating) {
        this.comment = comment;
        this.users = users;
        this.generalRating = generalRating;
    }

    public Float getGeneralRating() {
        return generalRating;
    }

    public void setGeneralRating(Float generalRating) {
        this.generalRating = generalRating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }
}
