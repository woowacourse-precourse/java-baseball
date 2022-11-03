package baseball.domain;

public class Hint {

    private int strike;
    private int ball;

    public Hint() {
        this.strike = 0;
        this.ball = 0;
    }

    public void increaseStrike() {
        strike++;
    }

    public void increaseBall() {
        ball++;
    }

    public boolean isOut() {
        return strike == 3;
    }

    public void init() {
        this.strike=0;
        this.ball=0;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
