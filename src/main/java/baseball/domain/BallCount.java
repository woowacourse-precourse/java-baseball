package baseball.domain;

import baseball.constant.BallCountText;

public class BallCount {

    private int ball;

    private int strike;

    public void init() {
        this.ball = 0;
        this.strike = 0;
    }

    public void increaseBall() {
        this.ball++;
    }

    public void decreaseBall() {
        this.ball--;
    }

    public void increaseStrike() {
        this.strike++;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        if (!isBallZero()) {
            result.append(ball + BallCountText.BALL);
        }
        if (!isStrikeZero()) {
            result.append(strike + BallCountText.STRIKE);
        }
        if (isStrikeZero() && isBallZero()) {
            result.append(BallCountText.NOTHING);
        }
        return result.toString();
    }

    public boolean isAllStrike() {
        return this.strike == 3;
    }

    private boolean isBallZero() {
        return this.ball == 0;
    }

    private boolean isStrikeZero() {
        return this.strike == 0;
    }
}
