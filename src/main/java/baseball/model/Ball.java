package baseball.model;

public class Ball {

    private int ball;
    private int strike;

    public Ball(int ball, int strike) {
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
