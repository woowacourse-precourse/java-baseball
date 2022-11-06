package baseball;

public class BallCount {
    // TODO: <Class> Ball Count (strikes, balls)
    private int strike;
    private int ball;

    public BallCount(){
        strike = 0;
        ball = 0;
    }

    // GETTER, SETTER
    public int getStrike() {
        return strike;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
