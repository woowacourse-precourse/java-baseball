package domain;

import constant.Messages;

import java.util.List;
import java.util.Objects;

public class Number {
    private int number;

    public Number(int number) {
        isValidNumber(number);
        this.number = number;
    }

    private void isValidNumber(int number) {
        if(number < 1 || 9 < number) throw new IllegalArgumentException(Messages.rangeOut);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return number == number1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
