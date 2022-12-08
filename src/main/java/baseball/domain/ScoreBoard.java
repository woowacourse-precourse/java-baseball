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
    public boolean equals(Object obj) {
        if (obj instanceof ScoreBoard) {
            ScoreBoard other = (ScoreBoard) obj;
            return this.strike == other.getStrike() && this.ball == other.getBall();
        }
        return false;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        appendBall(builder);
        appendStrike(builder);
        appendNothing(builder);

        return builder.toString();
    }

    private static void appendNothing(StringBuilder builder) {
        if (builder.length() == 0) {
            builder.append("낫싱");
        }
    }

    private void appendStrike(StringBuilder builder) {
        if (strike != 0) {
            builder.append(strike).append("스트라이크");
        }
    }

    private void appendBall(StringBuilder builder) {
        if (ball != 0) {
            builder.append(ball).append("볼 ");
        }
    }
}
