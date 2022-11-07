package baseball.domain.number;

import java.util.Objects;

public class BaseBallGameNumber {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int value;

    public BaseBallGameNumber(String input) {
        validateInputIsInteger(input);

        int number = Integer.parseInt(input);

        validateIntegerRange(number);

        this.value = number;
    }

    public BaseBallGameNumber(int number) {
        validateIntegerRange(number);

        this.value = number;
    }

    private void validateInputIsInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("입력값이 정수가 아닙니다.");
        }
    }

    private void validateIntegerRange(int number) {
        if (MIN_NUMBER > number || MAX_NUMBER < number) {
            throw new IllegalArgumentException("입력값이 1~9 사이의 정수가 아닙니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (!(o instanceof BaseBallGameNumber)) {
            return false;
        }

        BaseBallGameNumber that = (BaseBallGameNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    public int value() {
        return value;
    }
}
