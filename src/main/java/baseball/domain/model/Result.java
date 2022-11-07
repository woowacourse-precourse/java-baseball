package baseball.domain.model;

public class Result {
    private final int strike;
    private final int ball;
    private final boolean isOut;

    public Result(int strike, int ball, boolean isOut) {
        this.strike = strike;
        this.ball = ball;
        this.isOut = isOut;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean isOut(){
        return isOut;
    }


}
