package baseball;

import java.util.List;
import java.util.Set;

public class Numbers {

    private final ThreeDigits threeDigits;

    public Numbers(List<Integer> digits) {
        validateNoDuplicates(digits);
        this.threeDigits = new ThreeDigits(digits);
    }

    private void validateNoDuplicates(List<Integer> digits) {
        Set<Integer> digitsSet = Set.copyOf(digits);
        if (digits.size() != digitsSet.size()) {
            throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
        }
    }

    public Long countStrikesWith(Numbers other) {
        return threeDigits.countPositionMatches(other.threeDigits);
    }

    public Long countBallsWith(Numbers other) {
        return threeDigits.countDigitMatches(other.threeDigits);
    }
}
