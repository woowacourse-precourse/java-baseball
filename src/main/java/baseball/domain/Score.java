package baseball.domain;

public class Score {
    private int strike;
    private int ball;

    public Score(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void increaseStrike() {
        this.strike += 1;
    }

    public void increaseBall() {
        this.ball += 1;
    }
}
