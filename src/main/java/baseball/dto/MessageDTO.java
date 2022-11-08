package baseball.dto;

public class MessageDTO {
    private String message;
    private Boolean isOver;

    public MessageDTO() {
        this.message = "";
        this.isOver = false;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setOver(Boolean over) {
        this.isOver = over;
    }

    public String getMessage() {
        return this.message;
    }

    public Boolean getIsOver() {
        return this.isOver;
    }
}
