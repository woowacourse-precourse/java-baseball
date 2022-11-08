package baseball.domain;

public class Result {

    public static final int BALL_SIZE = 3;

    private boolean isGameOver = false;

    private int strikeCount = 0;
    private int ballCount = 0;

    public void addStrikeCount() {
        if (!isGameOver) {
            this.strikeCount++;
        }
    }

    public void addBallCount() {
        if (!isGameOver) {
            this.ballCount++;
        }
    }

    public boolean checkGameOver() {
        if (strikeCount == BALL_SIZE) {
            isGameOver = true;
        }

        return isGameOver;
    }

    @Override
    public String toString() {
        if (ballCount != 0 && strikeCount != 0) {
            return ballCount + "볼" +
                    " " +
                    strikeCount + "스트라이크";
        }

        if (ballCount != 0) {
            return ballCount + "볼";
        }

        if (strikeCount != 0) {
            return strikeCount + "스트라이크";
        }

        return "낫싱";
    }
}
