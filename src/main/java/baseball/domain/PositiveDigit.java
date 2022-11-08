package baseball.domain;

import static camp.nextstep.edu.missionutils.Randoms.*;

public class PositiveDigit {

    private static final int MINIMUM = 1;
    private static final int MAXIMUM = 9;

    private final int digit;

    public PositiveDigit(int digit) {
        validateRanges(digit);
        this.digit = digit;
    }

    public static PositiveDigit createRandomized() {
        return new PositiveDigit(pickNumberInRange(MINIMUM, MAXIMUM));
    }

    private void validateRanges(int digit) {
        if (digit < MINIMUM) {
            throw new IllegalArgumentException("숫자는 " + MINIMUM + " 이상이어야 합니다");
        }
        if (digit > MAXIMUM) {
            throw new IllegalArgumentException("숫자는 " + MAXIMUM + " 이하여야 합니다");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        PositiveDigit that = (PositiveDigit)o;

        return digit == that.digit;
    }

    @Override
    public int hashCode() {
        return digit;
    }
}
