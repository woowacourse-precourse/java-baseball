package baseball.domain;

import java.util.List;

public class GameResult {
    private static final int STRIKE_INDEX = 0;
    private static final int BALL_INDEX = 0;
    private int strike;
    private int ball;

    public GameResult(List<Integer> resultList) {
        strike = resultList.get(STRIKE_INDEX);
        ball = resultList.get(BALL_INDEX);
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }
}
