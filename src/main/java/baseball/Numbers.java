package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class Numbers {

    private static final int DIGITS_LENGTH = 3;

    private final ExclusiveDigits<PositiveDigit> exclusiveDigits;

    public Numbers(List<Integer> digits) {
        validateLength(digits);

        List<PositiveDigit> positiveDigits = digits.stream()
                .map(PositiveDigit::new)
                .collect(Collectors.toList());
        this.exclusiveDigits = new ExclusiveDigits<>(positiveDigits);
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
