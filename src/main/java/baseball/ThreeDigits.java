package baseball;

import java.util.List;
import java.util.stream.Collectors;

public class ThreeDigits {

    private static final int DIGITS_LENGTH = 3;

    private final List<PositiveDigit> digits;

    public ThreeDigits(List<Integer> digits) {
        validateLength(digits);
        this.digits = digits.stream()
                .map(PositiveDigit::new)
                .collect(Collectors.toList());
    }

    private void validateLength(List<Integer> digits) {
        if (digits.size() != DIGITS_LENGTH) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다");
        }
    }

    public Long countPositionMatches(ThreeDigits other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) == other.positionOf(digit))
                .count();
    }

    public Long countDigitMatches(ThreeDigits other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) != other.positionOf(digit))
                .count();
    }

    private int positionOf(PositiveDigit digit) {
        return digits.indexOf(digit);
    }
}
