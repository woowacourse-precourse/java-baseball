package baseball.model;

public class Judgement {
    private final int ball;
    private final int strike;

    public Judgement(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
