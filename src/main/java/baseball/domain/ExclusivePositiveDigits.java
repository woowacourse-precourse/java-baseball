package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExclusivePositiveDigits {

    private final List<PositiveDigit> digits;

    public ExclusivePositiveDigits(List<PositiveDigit> digits) {
        validateNoDuplicates(digits);
        this.digits = new ArrayList<>(digits);
    }

    private void validateNoDuplicates(List<PositiveDigit> digits) {
        Set<PositiveDigit> digitsSet = Set.copyOf(digits);
        if (digits.size() != digitsSet.size()) {
            throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
        }
    }

    public Long countPositionMatches(ExclusivePositiveDigits other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) == other.positionOf(digit))
                .count();
    }

    public Long countDigitMatches(ExclusivePositiveDigits other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) != other.positionOf(digit))
                .count();
    }

    private int positionOf(PositiveDigit digit) {
        return digits.indexOf(digit);
    }
}
