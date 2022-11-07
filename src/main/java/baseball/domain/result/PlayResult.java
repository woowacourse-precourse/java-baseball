package baseball.domain.result;

import baseball.domain.ball.BallType;

public class PlayResult {

    private final static int DEFAULT_COUNT = 0;
    private final static int GAME_END_COUNT = 3;

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
        return strike == DEFAULT_COUNT && ball == DEFAULT_COUNT;
    }

    public boolean isGameEnd() {
        return strike == GAME_END_COUNT;
    }

}