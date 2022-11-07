package baseball.domain;

import java.util.Objects;

public class Ball {
    private static final String RANGE_EXCEPTION_MESSAGE = "1 ~ 9 사이 숫자를 입력해주세요";
    static final int MAX_RANGE = 9;
    static final int MIN_RANGE = 1;

    private int number;

    public Ball(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < MIN_RANGE || number > MAX_RANGE) {
            throw new IllegalArgumentException(RANGE_EXCEPTION_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
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
