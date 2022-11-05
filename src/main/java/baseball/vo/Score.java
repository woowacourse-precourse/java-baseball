package baseball.vo;

public class Score {
    private int ball;
    private int strike;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getBall() {
        return this.ball;
    }

    public int getStrike() {
        return this.strike;
    }
}
