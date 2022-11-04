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
}
