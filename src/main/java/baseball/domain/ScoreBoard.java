package baseball.domain;

import static baseball.utils.ErrorMessage.INVALID_BALL_NUMBER;
import static baseball.utils.ErrorMessage.INVALID_STRIKE_NUMBER;
import static baseball.utils.ProgressMessage.*;

public class ScoreBoard {

    private static final int MIN_NUMBER = 0;
    private static final int MAX_BALL = 4;
    private static final int MAX_STRIKE = 3;

    private final int ball;
    private final int strike;

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
        return (ball < MIN_NUMBER) || (ball > MAX_BALL);
    }

    private void validateStrike(int strike) {
        if (isOutOfRangeByStrike(strike)) {
            throw new IllegalArgumentException(INVALID_STRIKE_NUMBER.getMessage());
        }
    }

    private static boolean isOutOfRangeByStrike(int strike) {
        return (strike < MIN_NUMBER) || (strike > MAX_STRIKE);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof ScoreBoard) {
            ScoreBoard other = (ScoreBoard) obj;
            return (this.strike == other.getStrike()) && (this.ball == other.getBall());
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

    private void appendBall(StringBuilder builder) {
        if (this.ball != 0) {
            builder.append(this.ball).append(BALL).append(" ");
        }
    }

    private void appendStrike(StringBuilder builder) {
        if (this.strike != 0) {
            builder.append(this.strike).append(STRIKE);
        }
    }

    private static void appendNothing(StringBuilder builder) {
        if (builder.length() == 0) {
            builder.append(NOTHING);
        }
    }

}
