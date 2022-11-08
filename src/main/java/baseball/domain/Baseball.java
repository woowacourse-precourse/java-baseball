package baseball.domain;

public class Baseball {
    int ball;
    int strike;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public Baseball() {
        this.ball = 0;
        this.strike = 0;
    }

    public Baseball(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public void strike() {
        this.strike += 1;
    }

    public void ball() {
        this.ball += 1;
    }
}
