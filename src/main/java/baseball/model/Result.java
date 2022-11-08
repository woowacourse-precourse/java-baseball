package baseball.model;

public class Result {

    private static final int CORRECT_COUNT = 3;

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
        return strike == 0 && ball == 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
