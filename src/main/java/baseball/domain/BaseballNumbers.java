package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {
    private static final int VALID_BASEBALL_COUNT = 3;

    List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateSize(baseballNumbers);
        validateDuplicate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateSize(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != VALID_BASEBALL_COUNT) {
            throw new BaseballGameException();
        }
    }

    private void validateDuplicate(List<BaseballNumber> baseballNumbers) {
        HashSet<BaseballNumber> nonDuplicateBaseballs = new HashSet<>(baseballNumbers);
        if (nonDuplicateBaseballs.size() != VALID_BASEBALL_COUNT) {
            throw new BaseballGameException();
        }
    }
}
