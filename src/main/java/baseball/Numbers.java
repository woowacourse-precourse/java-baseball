package baseball;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Numbers {

    private static final int DIGIT_MINIMUM = 1;
    private static final int DIGIT_MAXIMUM = 9;
    private static final int DIGITS_LENGTH = 3;

    private final List<Integer> digits;

    public Numbers(List<Integer> digits) {
        validateLength(digits);
        validateRanges(digits);
        validateNoDuplicates(digits);
        this.digits = new ArrayList<>(digits);
    }

    private void validateLength(List<Integer> digits) {
        if (digits.size() != DIGITS_LENGTH) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다");
        }
    }

    private void validateNoDuplicates(List<Integer> digits) {
        Set<Integer> digitsSet = Set.copyOf(digits);
        if (digits.size() != digitsSet.size()) {
            throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
        }
    }

    private void validateRanges(List<Integer> digits) {
        for (Integer digit : digits) {
            if (digit < DIGIT_MINIMUM) {
                throw new IllegalArgumentException("각 숫자는 1 이상이어야 합니다");
            }
            if (digit > DIGIT_MAXIMUM) {
                throw new IllegalArgumentException("각 숫자는 9 이하여야 합니다");
            }
        }
    }

    public int countStrikesWith(Numbers other) {
        int strikes = 0;
        for (Integer digit : digits) {
            if (other.doesNotContain(digit)) {
                continue;
            }
            if (other.positionOf(digit) == this.positionOf(digit)) {
                strikes += 1;
            }
        }
        return strikes;
    }

    public int countBallsWith(Numbers other) {
        int balls = 0;
        for (Integer digit : digits) {
            if (other.doesNotContain(digit)) {
                continue;
            }
            if (other.positionOf(digit) != this.positionOf(digit)) {
                balls += 1;
            }
        }
        return balls;
    }

    private boolean doesNotContain(Integer digit) {
        return !digits.contains(digit);
    }

    private int positionOf(Integer digit) {
        return digits.indexOf(digit);
    }
}
