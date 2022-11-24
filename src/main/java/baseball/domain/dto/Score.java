package baseball.domain.dto;

import baseball.system.SystemConstant;

import java.util.ArrayList;
import java.util.Arrays;

public class Score {
    private final int ball;
    private final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public boolean isGameOver() {
        return strike == SystemConstant.GAME_DIGIT;
    }

    @Override
    public String toString() {
        return "";
    }
}
