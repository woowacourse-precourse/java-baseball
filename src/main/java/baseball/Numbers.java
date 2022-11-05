package baseball;

import java.util.List;

public class Numbers {

    private static final int DIGITS_LENGTH = 3;

    private final ExclusiveDigits exclusiveDigits;

    public Numbers(List<Integer> digits) {
        validateLength(digits);
        this.exclusiveDigits = new ExclusiveDigits(digits);
    }

    private void validateLength(List<Integer> digits) {
        if (digits.size() != DIGITS_LENGTH) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다");
        }
    }

    public Long countStrikesWith(Numbers other) {
        return exclusiveDigits.countPositionMatches(other.exclusiveDigits);
    }

    public Long countBallsWith(Numbers other) {
        return exclusiveDigits.countDigitMatches(other.exclusiveDigits);
    }
}
