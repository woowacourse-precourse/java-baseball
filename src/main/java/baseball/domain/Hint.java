package baseball.domain;

import baseball.constant.BallCountConstant;

public class Hint {

    private static final int DIGITS = 3;

    private int strikes;

    private int balls;

    public Hint() {
        this.strikes = 0;
        this.balls = 0;
    }

    public void increaseStrike() {
        this.strikes++;
    }

    public void increaseBall() {
        this.balls++;
    }

    public boolean isZeroBall() {
        return this.balls == 0;
    }

    public boolean isZeroStrike() {
        return this.strikes == 0;
    }

    public boolean isAllStrike() {
        return this.strikes == DIGITS;
    }

    public String toString() {
        StringBuilder result = new StringBuilder();

        if (!isZeroBall()) {
            result.append(balls + BallCountConstant.BALL);
        }
        if (!isZeroStrike()) {
            result.append(strikes + BallCountConstant.STRIKE);
        }
        if (isZeroBall() && isZeroStrike()) {
            result.append(BallCountConstant.NOTHING);
        }
        return result.toString();
    }
}
