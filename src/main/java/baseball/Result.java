package baseball;

public class Result {
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
        return ballCount == 0 && strikeCount == 0;
    }

    public boolean hasBall() {
        return ballCount != 0;
    }

    public boolean hasStrike() {
        return strikeCount != 0;
    }

    public boolean isGameOver() {
        return strikeCount == 3;
    }
}
