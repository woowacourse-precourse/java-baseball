package baseball.Model;

public class BallCountItem {
    private int strike;
    private int ball;

    public BallCountItem() {
        this.strike = 0;
        this.ball = 0;
    }

    public void initialization() {
        this.strike = 0;
        this.ball = 0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
