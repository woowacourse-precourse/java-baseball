package baseball;

import java.util.Objects;

public class BallNumber {
    private int number;

    public BallNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int number) {
        if (number < MessageUtils.MIN_NUMBER || number > MessageUtils.MAX_NUMBER) {
            throw new IllegalArgumentException(MessageUtils.NUMBER_OUT_OF_RANGE_MESSAGE);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BallNumber that = (BallNumber) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}