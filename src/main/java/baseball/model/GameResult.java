package baseball.model;

public class GameResult {

    private static final int CORRECT_COUNT = 3;
    private static final int NONE_MATCH = 0;

    private int strike;
    private int ball;

    public void add(BallStatus status) {
        if (status.isStrike()) {
            strike++;
        }

        if (status.isBall()) {
            ball++;
        }
    }

    public boolean isGameEnd() {
        return strike == CORRECT_COUNT;
    }

    public boolean isNothing() {
        return strike == NONE_MATCH && ball == NONE_MATCH;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
