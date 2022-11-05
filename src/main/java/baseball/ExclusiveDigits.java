package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ExclusiveDigits {

    private final List<PositiveDigit> digits;

    public ExclusiveDigits(List<Integer> digits) {
        validateNoDuplicates(digits);
        this.digits = digits.stream()
                .map(PositiveDigit::new)
                .collect(Collectors.toList());
    }

    private void validateNoDuplicates(List<Integer> digits) {
        Set<Integer> digitsSet = Set.copyOf(digits);
        if (digits.size() != digitsSet.size()) {
            throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
        }
    }

    public Long countPositionMatches(ExclusiveDigits other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) == other.positionOf(digit))
                .count();
    }

    public Long countDigitMatches(ExclusiveDigits other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) != other.positionOf(digit))
                .count();
    }

    private int positionOf(PositiveDigit digit) {
        return digits.indexOf(digit);
    }
}
