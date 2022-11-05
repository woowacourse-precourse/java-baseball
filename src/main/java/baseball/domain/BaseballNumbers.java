package baseball.domain;

import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {
    private static final int BASEBALL_NUMBERS_SIZE = 3;

    List<BaseballNumber> baseballNumbers;

    public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
        validateSize(baseballNumbers);
        validateDuplicate(baseballNumbers);
        this.baseballNumbers = baseballNumbers;
    }

    private void validateSize(List<BaseballNumber> baseballNumbers) {
        if (baseballNumbers.size() != BASEBALL_NUMBERS_SIZE) {
            throw new BaseballGameException();
        }
    }

    private void validateDuplicate(List<BaseballNumber> baseballNumbers) {
        HashSet<BaseballNumber> nonDuplicateBaseballs = new HashSet<>(baseballNumbers);
        if (nonDuplicateBaseballs.size() != BASEBALL_NUMBERS_SIZE) {
            throw new BaseballGameException();
        }
    }
}
