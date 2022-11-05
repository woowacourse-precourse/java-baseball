package baseball;

import static baseball.ResultType.*;

public class Result {

    private ResultType resultType;

    private int ball = 0;
    private int strike = 0;

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    public void calculateType() {
        if (strike == 3) resultType = EXACT_MATCH;
        else if (strike > 0 && ball > 0) resultType = BALL_AND_STRIKE;
        else if (strike > 0) resultType = ONLY_STRIKE;
        else if (ball > 0) resultType = ONLY_BALL;
        else resultType = NOTHING;
    }

    public ResultType getResultType() {
        return resultType;
    }
}
