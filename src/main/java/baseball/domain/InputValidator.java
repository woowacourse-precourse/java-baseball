package baseball.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {
    private static final int VALID_LENGTH = 3;
    private static final int VALID_MIN_RANGE = 1;
    private static final int VALID_MAX_RANGE = 9;
    private static final String LENGTH_ERROR_MESSAGE = "숫자는 세 자리 수여야 합니다.";
    private static final String RANGE_ERROR_MESSAGE = "각 자리 수는 최소 1 이상, 최대 9 이하의 정수여야 합니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "숫자는 중복되어서는 안됩니다.";

    public boolean hasValidInput(List<Integer> input) {
        hasValidLength(input);
        hasValidRange(input);
        hasNonDuplicateNumbers(input);
        return true;
    }

    private void hasValidLength(List<Integer> input) {
        if (!(input.size() == VALID_LENGTH)) {
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
        }
    }

    private void hasValidRange(List<Integer> input) {
        if (!(Collections.max(input) <= VALID_MAX_RANGE && Collections.min(input) >= VALID_MIN_RANGE)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private void hasNonDuplicateNumbers(List<Integer> input) {
        Set<Integer> inputSet = new HashSet<>(input);
        if (!(inputSet.size() == input.size())) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
    }
}
