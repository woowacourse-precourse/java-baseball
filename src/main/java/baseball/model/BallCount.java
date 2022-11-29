package baseball.model;

public enum BallCount {
    STRIKE("스트라이크"), BALL("볼"), NOTHING("낫싱");

    private final String display;

    BallCount(String display) {
        this.display = display;
    }
}
