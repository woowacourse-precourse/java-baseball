package baseball.domain;

public enum BallStatus {
    BALL, STRIKE, NOTHING;

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }
}
