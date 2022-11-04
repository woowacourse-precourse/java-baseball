package baseball.domain;

import java.util.Objects;

public class NumberBall {
    private int number;

    public NumberBall(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int number) {
        if (!rangeNumber(number)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean rangeNumber(int number) {
        return number >= 1 && number <= 9;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        NumberBall that = (NumberBall) o;
        return getNumber() == that.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
