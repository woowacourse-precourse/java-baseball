package baseball.domain;

public enum BaseballCount {
    STRIKE("strike", "스트라이크"),
    BALL("ball", "볼");

    public String getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    private final String value;

    private final String message;

    BaseballCount(String value, String message) {
        this.value = value;
        this.message = message;
    }
}
