package baseball.domain;

public class PlayResult {
    private int strike = 0;
    private int ball = 0;

    public void updateResult(BallStatus ballStatus) {
        if (ballStatus.isStrike()) {
            strike++;
        }
        if (ballStatus.isBall()) {
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
