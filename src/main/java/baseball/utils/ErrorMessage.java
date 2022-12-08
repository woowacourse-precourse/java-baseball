package baseball.utils;

public enum ErrorMessage {
    INVALID_STRIKE_NUMBER("스트라이크의 범위는 0 ~ 3 입니다."),
    INVALID_BALL_NUMBER("볼의 범위는 0 ~ 3 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
