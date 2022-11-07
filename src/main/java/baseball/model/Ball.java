package baseball.model;

import java.util.Objects;

public class Ball {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int position;
    private final int number;

    public Ball(int position, int number) {
        validateNumber(number);
        this.position = position;
        this.number = number;
    }

    private void validateNumber(int number) {
        if (!isValideNumber(number)) {
            throw new IllegalArgumentException("1~9사이의 숫자만 입력 가능합니다.");
        }
    }

    private boolean isValideNumber(int number) {
        return MIN_NUMBER <= number && number <= MAX_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return position == ball.position && number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position, number);
    }
}
