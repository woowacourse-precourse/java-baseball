package baseball.domain;

import static baseball.vo.GameInterfaceMsg.*;

public class Score {
    private int strike;
    private int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void increaseStrike() {
        this.strike += 1;
    }

    public void increaseBall() {
        this.ball += 1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (getBall() != 0) {
            sb.append(getBall()).append(BALL.getMessage()).append(' ');
        }

        if (getStrike() != 0) {
            sb.append(getStrike()).append(STRIKE.getMessage());
        }

        if (getStrike() == 0 && getBall() == 0) {
            sb.append(NOTHING.getMessage());
        }

        return sb.toString();
    }
}
