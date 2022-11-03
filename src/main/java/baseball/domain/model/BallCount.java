package baseball.domain.model;

public enum BallCount {

    OUT(0, "아웃"),
    BALL(1, "볼"),
    STRIKE(2, "스트라이크");

    private final int code;
    private final String value;

    BallCount(final int code, final String value) {
        this.code = code;
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
