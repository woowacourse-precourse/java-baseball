package baseball.model;

public class User {

    public int strike = 0;
    public int ball = 0;

    public void addStrike() {
        strike++;
    }

    public void addBall() {
        ball++;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
