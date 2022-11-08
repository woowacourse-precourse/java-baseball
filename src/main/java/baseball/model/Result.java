package baseball.model;

public class Result {
    private static final int ZERO_COUNT = 0;
    private static final int FULL_COUNT = 3;
    int ballCount;
    int strikeCount;

    public int getBallCount() {
        return ballCount;
    }

    public int getStrikeCount() {
        return strikeCount;
    }

    public void increaseBallCount() {
        ballCount++;
    }

    public void increaseStrikeCount() {
        strikeCount++;
    }

    public boolean hasNothing() {
        return ballCount == ZERO_COUNT && strikeCount == ZERO_COUNT;
    }

    public boolean hasBall() {
        return ballCount != ZERO_COUNT;
    }

    public boolean hasStrike() {
        return strikeCount != ZERO_COUNT;
    }

    public boolean isGameOver() {
        return strikeCount == FULL_COUNT;
    }
}
