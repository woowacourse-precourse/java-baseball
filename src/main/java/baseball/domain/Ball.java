package baseball.domain;

import java.util.Objects;

public class Ball {

    public static final int MIN_BALL_NUMBER = 1;
    public static final int MAX_BALL_NUMBER = 9;
    public static final String BALL_RANGE_EXCEPTION_MESSAGE =
            "숫자의 범위는 " + MIN_BALL_NUMBER + "~" + MAX_BALL_NUMBER + "까지 가능합니다.";
    private final int ball;

    public Ball(int ball) {
        this.ball = rangeValidate(ball);
    }

    private int rangeValidate(int number) {
        if (number >= MIN_BALL_NUMBER && MAX_BALL_NUMBER >= number) {
            return number;
        }
        throw new IllegalArgumentException(BALL_RANGE_EXCEPTION_MESSAGE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball1 = (Ball) o;
        return ball == ball1.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
