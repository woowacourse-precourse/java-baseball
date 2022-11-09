package baseball.service;

public class BallStatus {
    private final int strike;
    private final int ball;

    public BallStatus(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
