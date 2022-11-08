package baseball.model;

import java.util.Objects;

public class Ball {
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;
    private static final String INVALID_INPUT_RANGE_MESSAGE = "입력된 숫자의 값은 " + MIN_BALL_NUMBER + "부터 " + MAX_BALL_NUMBER + "사이의 값이어야 합니다.";

    int number;

    public Ball(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number >= MIN_BALL_NUMBER && number <= MAX_BALL_NUMBER) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT_RANGE_MESSAGE);
    }
    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
