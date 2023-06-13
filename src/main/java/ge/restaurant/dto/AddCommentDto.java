package ge.restaurant.dto;

public class AddCommentDto {
    private Long userId;
    private String comment;

    public AddCommentDto() {
    }

    public AddCommentDto(Long userId, String comment) {
        this.userId = userId;
        this.comment = comment;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
