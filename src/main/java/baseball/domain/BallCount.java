package baseball.domain;

import static baseball.rule.Digit.DIGITS;

import baseball.constant.BallCountText;

public class BallCount {

    private int ball;

    private int strike;

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
        return this.strike == DIGITS;
    }

    private boolean isBallZero() {
        return this.ball == 0;
    }

    private boolean isStrikeZero() {
        return this.strike == 0;
    }
}
