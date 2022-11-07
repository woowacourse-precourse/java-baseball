package baseball.model;

import static baseball.model.CountStatus.*;

public class Score {
    private int ball;
    private int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public CountStatus status() {
        if (NO_COUNT.check(this)) {
            return NO_COUNT;
        }
        if (ONLY_BALL.check(this)) {
            return ONLY_BALL;
        }
        if (BALL_AND_STRIKE.check(this)) {
            return BALL_AND_STRIKE;
        }
        if (ONLY_STRIKE.check(this)) {
            return ONLY_STRIKE;
        }
        throw new IllegalArgumentException("illegal score");
    }

    public boolean isThreeStrike() {
        return this.strike == 3;
    }
}
