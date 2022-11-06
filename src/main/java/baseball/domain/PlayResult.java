package baseball.domain;

public class PlayResult {

    private final static int DEFAULT_COUNT = 0;

    int strike = DEFAULT_COUNT;
    int ball = DEFAULT_COUNT;

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public void save(BallType type) {
        if (type.isStrike()) {
            strike++;
        }
        if (type.isBall()) {
            ball++;
        }
    }

    public boolean isNothing() {
        return strike == 0 && ball == 0;
    }

    public boolean isGameEnd() {
        return strike == 3;
    }

}