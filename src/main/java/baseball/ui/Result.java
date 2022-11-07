package baseball.ui;

import baseball.numbers.BallTypes;

import java.util.Map;

public class Result {
    private static final String BALL_MESSAGE = "볼 ";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SPACE = "";

    private final int ball;
    private final int strike;

    public Result(Map<BallTypes, Integer> result) {
        this.ball = result.getOrDefault(BallTypes.BALL, 0);
        this.strike = result.getOrDefault(BallTypes.STRIKE, 0);
    }

    @Override
    public String toString() {
        if (ball + strike == 0) {
            return NOTHING_MESSAGE;
        }
        return (ballResult(ball) + strikeResult(strike)).trim();
    }

    private String ballResult(int ball) {
        if (ball == 0) {
            return SPACE;
        }
        return ball + BALL_MESSAGE;
    }

    private String strikeResult(int strike) {
        if (strike == 0) {
            return SPACE;
        }
        return strike + STRIKE_MESSAGE;
    }
}
