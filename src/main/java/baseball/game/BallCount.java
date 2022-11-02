package baseball.game;

public class BallCount {
    private int ball = 0;
    private int strike = 0;

    public void plusBall() {
        this.ball++;
    }

    public void plusStrike() {
        this.strike++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
