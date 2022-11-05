package baseball.ball;

public enum BallResult {
    STRIKE,
    BALL,
    NOTHING;

    public boolean isNotNothing() {
        return this != BallResult.NOTHING;
    }

    public boolean isBall() {
        return this == BALL;
    }

    public boolean isStrike() {
        return this == STRIKE;
    }
}
