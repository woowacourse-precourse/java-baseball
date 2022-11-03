package baseball.domain;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public void updateResult(BallStatus ballStatus) {
        if (ballStatus == BallStatus.STRIKE) {
            strike++;
        }
        if (ballStatus == BallStatus.BALL) {
            ball++;
        }
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
