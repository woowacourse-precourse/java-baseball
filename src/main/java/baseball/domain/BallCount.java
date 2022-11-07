package baseball.domain;

import static baseball.view.BaseballGameConstant.ALL_MATCHED_MESSAGE;
import static baseball.view.BaseballGameConstant.BALL_COUNT;
import static baseball.view.BaseballGameConstant.NOTHING_MATCHED;
import static baseball.view.BaseballGameConstant.STRIKE_COUNT;

public class BallCount {
    private final int strike;
    private final int ball;

    public BallCount(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isFinished() {
        if (strike == 3) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        if (getBall() == 0 && getStrike() == 0) {
            return NOTHING_MATCHED;
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (getStrike() == 3) {
            stringBuilder.append(getStrike()).append(STRIKE_COUNT).append("\n").append(ALL_MATCHED_MESSAGE);
        }
        if (getBall() > 0) {
            stringBuilder.append(getBall()).append(BALL_COUNT);
        }
        if (getStrike() > 0) {
            stringBuilder.append(getStrike()).append(STRIKE_COUNT);
        }
        return stringBuilder.toString();
    }
}
