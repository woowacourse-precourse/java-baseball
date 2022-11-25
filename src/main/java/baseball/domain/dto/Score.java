package baseball.domain.dto;

import baseball.system.SystemConstant;

public class Score {
    private final int ball;
    private final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public int getBall() {
        return ball;
    }

    public int getStrike() {
        return strike;
    }

    public boolean isGameOver() {
        return strike == SystemConstant.GAME_DIGIT;
    }
}
