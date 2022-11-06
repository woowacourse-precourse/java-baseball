package baseball.result;

import static baseball.result.ResultType.*;

public class Result {

    private ResultType resultType = NOTHING;

    private int ball = 0;
    private int strike = 0;

    public void increaseStrike() {
        strike++;
        calculateType();
    }

    public void increaseBall() {
        ball++;
        calculateType();
    }

    private void calculateType() {
        if (strike == 3) resultType = EXACT_MATCH;
        else if (strike > 0 && ball > 0) resultType = BALL_AND_STRIKE;
        else if (strike > 0) resultType = ONLY_STRIKE;
        else if (ball > 0) resultType = ONLY_BALL;
        else resultType = NOTHING;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public int numberOfBall() {
        return ball;
    }

    public int numberOfStrike() {
        return strike;
    }
}
