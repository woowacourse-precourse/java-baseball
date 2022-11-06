package baseball.domain;

import java.util.ArrayList;
import java.util.Arrays;

public class Score {
    private final int ball;
    private final int strike;

    public Score(int ball, int strike) {
        this.ball = ball;
        this.strike = strike;
    }

    public ArrayList<Integer> getScore() {
        return new ArrayList<>(Arrays.asList(ball, strike));
    }
}
