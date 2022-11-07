package baseball.domain;

import java.util.Objects;

public class Ball {

    private int number;

    public Ball(int number) {
        validateRange(number);
        this.number = number;
    }

    private void validateRange(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("1 ~ 9 사이 숫자를 입력해주세요");
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
