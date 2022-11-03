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
}
