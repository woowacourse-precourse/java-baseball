package baseball.game.number;

public class Score {
    private int strike = 0;
    private int ball = 0;
    private int out = 0;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public int getOut() {
        return out;
    }

    public void update(int strike, int ball, int out) {
        this.strike = strike;
        this.ball = ball;
        this.out = out;
    }
}
