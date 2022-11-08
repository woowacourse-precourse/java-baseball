package baseball.domain;

import java.util.List;

public class Hint {
    private int strike;
    private int ball;

    public Hint(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void setStrike(int strike) {
        this.strike = strike;
    }

    public void setBall(int ball) {
        this.ball = ball;
    }
}
