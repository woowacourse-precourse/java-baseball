package baseball.model;

public class BaseBall {
    private int strike;
    private int ball;

    public BaseBall() {
        this.strike = 0;
        this.ball = 0;
    }

    public void setStrike(int strikeCount) {
        this.strike = strikeCount;
    }

    public void setBall(int ballCount) {
        this.ball = ballCount;
    }

    public void resetCount() {
        this.strike = 0;
        this.ball = 0;
    }
}
