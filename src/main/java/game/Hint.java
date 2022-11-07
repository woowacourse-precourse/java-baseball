package game;

public class Hint {
    private static int ball = 0;
    private static int strike = 0;

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public void incrementBall() {
        ball++;
    }

    public void incrementStrike() {
        strike++;
    }

    public void clearHint() {
        ball = 0;
        strike = 0;
    }
}
