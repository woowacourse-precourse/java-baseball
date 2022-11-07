package baseball.model;

public class Score {
    int ball;
    int strike;

    public Score () {
        ball = 0;
        strike = 0;
    }

    public void countBall() {
        this.ball++;
    }

    public void countStrike() {
        this.strike++;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }
}