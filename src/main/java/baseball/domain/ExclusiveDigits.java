package baseball.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ExclusiveDigits<E extends Digit> {

    private final List<E> digits;

    public ExclusiveDigits(List<E> digits) {
        validateNoDuplicates(digits);
        this.digits = new ArrayList<>(digits);
    }

    private void validateNoDuplicates(List<E> digits) {
        Set<E> digitsSet = Set.copyOf(digits);
        if (digits.size() != digitsSet.size()) {
            throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
        }
    }

    public Long countPositionMatches(ExclusiveDigits<E> other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) == other.positionOf(digit))
                .count();
    }

    public Long countDigitMatches(ExclusiveDigits<E> other) {
        return digits.stream()
                .filter(other.digits::contains)
                .filter(digit -> positionOf(digit) != other.positionOf(digit))
                .count();
    }

    private int positionOf(E digit) {
        return digits.indexOf(digit);
    }
}
