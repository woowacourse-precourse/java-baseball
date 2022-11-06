package baseball.result;

public class Result {
    private int strike;
    private int ball;

    public Result(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isCorrect() {
        return strike == 3;
    }

    public boolean isNothing() {
        if (strike == 0 && ball == 0) {
            return true;
        }
        return false;
    }
}
