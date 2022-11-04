package baseball.domain;

public enum BallStatus {
    STRIKE, NOTHING, BALL;

    public boolean isNotNothing() {
        return this != NOTHING;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isNothing() {
        return this == NOTHING;
    }
}
