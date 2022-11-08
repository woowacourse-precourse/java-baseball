package baseball.core;

public class Count {
    private int ball;
    private int strike;

    public Count() {
        this.setBall(0);
        this.setStrike(0);
    }

    public int getBall() {
        return ball;
    }

    public Count setBall(int ball) {
        this.ball = ball;
        return this;
    }

    public int getStrike() {
        return strike;
    }

    public Count setStrike(int strike) {
        this.strike = strike;
        return this;
    }
}
