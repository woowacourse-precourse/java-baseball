package baseball.model;


public class BallStatus {
    private final int ball;
    private final int strike;

    public BallStatus(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    @Override
    public String toString() {
        if (ball == 0 && strike == 0) {
            return "낫싱";
        }

        if (ball == 0) {
            return strike + "스트라이크";
        }

        if (strike == 0) {
            return ball + "볼";
        }

        return ball + "볼 " + strike + "스트라이크";
    }
}
