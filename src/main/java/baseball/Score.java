package baseball;

public class Score {
    private int strike;
    private int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public boolean isNothing() {
        return (strike|ball) == 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}
