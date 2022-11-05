package baseball;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    private static final int DIGITS_LENGTH = 3;

    private final List<Digit> digits;

    public Numbers(List<Integer> digits) {
        validateLength(digits);
        validateNoDuplicates(digits);
        this.digits = digits.stream()
                .map(Digit::new)
                .collect(Collectors.toList());
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

    public Long countStrikesWith(Numbers other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) == other.positionOf(digit))
                .count();
    }

    public Long countBallsWith(Numbers other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) != other.positionOf(digit))
                .count();
    }

    private int positionOf(Digit digit) {
        return digits.indexOf(digit);
    }
}
