package baseball;

public class Ball {
    private int ball;
    private int strike;

    public Ball(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }

    public int getStrike() {
        return this.strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }
}
