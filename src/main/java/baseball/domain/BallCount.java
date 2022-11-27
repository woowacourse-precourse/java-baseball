package baseball.domain;

public enum BallCount {
    STRIKE(1, 0),
    BALL(0, 1),
    NOTHING(0, 0);

    private final int strikeCount;
    private final int ballCount;

    BallCount(int strikeCount, int ballCount) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
    }
}
