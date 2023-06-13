package ge.restaurant.dto;

import ge.restaurant.models.Users;

public class CommentDto {
    private String comment;
    private Users users;

    public CommentDto() {
    }

    public CommentDto(String comment, Users users) {
        this.comment = comment;
        this.users = users;
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
