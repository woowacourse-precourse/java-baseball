package baseball;

public class BaseballScore {
    private int ball;
    private int strike;

    public BaseballScore() {
        ball = 0;
        strike = 0;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void increaseBall() {
        ball++;
    }

    public void increaseStrike() {
        strike++;
    }
}