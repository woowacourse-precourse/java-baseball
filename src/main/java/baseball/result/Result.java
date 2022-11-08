package baseball.result;

public class Result {

    private ResultType resultType = ResultType.NOTHING;

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
        if (strike == 3) {
            resultType = ResultType.EXACT_MATCH;
        } else if (strike > 0 && ball > 0) {
            resultType = ResultType.BALL_AND_STRIKE;
        } else if (strike > 0) {
            resultType = ResultType.ONLY_STRIKE;
        } else if (ball > 0) {
            resultType = ResultType.ONLY_BALL;
        } else if (ball == 0 && strike == 0){
            resultType = ResultType.NOTHING;
        }
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
