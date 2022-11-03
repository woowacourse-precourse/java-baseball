package baseball.domain;

public class PlayResult {
    private int strike;
    private int ball;


    public void updateStrike(int strike) {
        this.strike = strike;
    }

    public void updateBall(int ball) {
        this.ball = ball - strike;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
