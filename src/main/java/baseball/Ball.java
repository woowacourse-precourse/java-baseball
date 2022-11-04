package baseball;

public class Ball {
    private int ball;
    private int strike;

    public Ball() {
        this.ball = 0;
        this.strike = 0;
    }

    public void increaseBall() {
        setBall(getBall() + 1);
    }

    public void increaseStrike() {
        setStrike(getStrike() + 1);
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
