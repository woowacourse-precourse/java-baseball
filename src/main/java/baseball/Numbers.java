package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> digits;

    public Numbers(List<Integer> digits) {
        validateLength(digits);
        validateNoDuplicates(digits);
        this.digits = new ArrayList<>(digits);
    }

    private void validateLength(List<Integer> digits) {
        if (digits.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다");
        }
    }

    private void validateNoDuplicates(List<Integer> digits) {
        boolean[] appearances = new boolean[10];
        for (Integer digit : digits) {
            if (appearances[digit]) {
                throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
            }
            appearances[digit] = true;
        }
    }

    public int compareStrikes(Numbers other) {
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

    public int compareBalls(Numbers other) {
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
