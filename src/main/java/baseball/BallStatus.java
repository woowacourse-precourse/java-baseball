package baseball;

public enum BallStatus {
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private String value;

    BallStatus(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
