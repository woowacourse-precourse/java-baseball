package baseball.view;

public enum BallState {
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String label;

    BallState(String label) {
        this.label = label;
    }

    public String label() {
        return label;
    }
}
