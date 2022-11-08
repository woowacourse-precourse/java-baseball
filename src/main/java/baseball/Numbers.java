package baseball;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Numbers {

    private static final int DIGITS_LENGTH = 3;

    private final ExclusiveDigits<PositiveDigit> exclusiveDigits;

    private Numbers(List<PositiveDigit> digits) {
        validateLength(digits);
        this.exclusiveDigits = new ExclusiveDigits<>(digits);
    }

    public static Numbers fromIntegers(List<Integer> integers) {
        return new Numbers(integers.stream()
                .map(PositiveDigit::new)
                .collect(Collectors.toList()));
    }

    public static Numbers randomized() {
        Set<PositiveDigit> randomNumbers = new LinkedHashSet<>();
        while (randomNumbers.size() != DIGITS_LENGTH) {
            randomNumbers.add(PositiveDigit.randomized());
        }
        return new Numbers(new ArrayList<>(randomNumbers));
    }

    private void validateLength(List<PositiveDigit> digits) {
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
