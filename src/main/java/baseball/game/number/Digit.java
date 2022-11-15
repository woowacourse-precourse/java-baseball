package baseball.game.number;

import java.util.Objects;

public class Digit {
    public final int digitValue;

    public Digit(int digitValue) {
        validateDigitValue(digitValue);
        this.digitValue = digitValue;
    }

    private void validateDigitValue(int number) {
        if (isNotOneDigitNumber(number)) {
            throw new IllegalArgumentException("1 이상 9 이하의 숫자가 아닙니다.");
        }
    }

    private boolean isNotOneDigitNumber(int number) {
        return number < 1 || number > 9;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Digit digit = (Digit) o;
        return digitValue == digit.digitValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(digitValue);
    }
}
