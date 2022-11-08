package baseball.domain;

import java.util.Objects;

public class Number {
    private int value;

    public Number(int value) {
        this.value = value;
    }

    public Number(char value) {
        this.value = toInt(value);
    }

    private int toInt(char value) {
        value -= 48;
        if (value == 0) {
            throw new IllegalArgumentException("범위(1~9)를 벗어나는 수가 포함되었습니다.");
        }
        if (value < 1 || value > 9) {
            throw new IllegalArgumentException("숫자가 아닌 값이 포함되었습니다.");
        }
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number1 = (Number) o;
        return value == number1.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
