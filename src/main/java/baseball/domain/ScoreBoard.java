package baseball.domain;

import static baseball.utils.ErrorMessage.INVALID_BALL_NUMBER;
import static baseball.utils.ErrorMessage.INVALID_STRIKE_NUMBER;

public class ScoreBoard {
    private final int strike;
    private final int ball;

    ScoreBoard(int ball, int strike) {
        validateBall(ball);
        validateStrike(strike);
        this.ball = ball;
        this.strike = strike;
    }

    private void validateBall(int ball) {
        if (isOutOfRangeByBall(ball)) {
            throw new IllegalArgumentException(INVALID_BALL_NUMBER.getMessage());
        }
    }

    private boolean isOutOfRangeByBall(int ball) {
        return (ball < 0) || (ball > 4);
    }

    private void validateStrike(int strike) {
        if (isOutOfRangeByStrike(strike)) {
            throw new IllegalArgumentException(INVALID_STRIKE_NUMBER.getMessage());
        }
    }

    private static boolean isOutOfRangeByStrike(int strike) {
        return (strike < 0) || (strike > 3);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        if (ball != 0) {
            builder.append(ball).append("볼");
        }

        if (strike != 0) {
            builder.append(strike).append("스트라이크");
        }

        if (builder.length() == 0) {
            builder.append("낫싱");
        }

        return builder.toString();
    }
}
