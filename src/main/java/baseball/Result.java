package baseball;

public class Result {
    private int strike;
    private int ball;

    public int getStrike() {
        return this.strike;
    }

    public int getBall() {
        return this.ball;
    }

    public void report(BallStatus status) {
        if (status == BallStatus.BALL) {
            this.ball++;
        }
        if (status == BallStatus.STRIKE) {
            this.strike++;
        }
    }
}
