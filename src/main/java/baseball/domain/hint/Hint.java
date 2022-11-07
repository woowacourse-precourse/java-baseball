package baseball.domain.hint;

public class Hint {

    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static Hint create(int strike, int ball) {
        return new Hint(strike, ball);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
