package baseball.model.number;

import java.util.List;

public class BaseballNumbers {
    private static final String INPUT_SIZE_ERROR = "입력하는 수는 3자리여야 합니다";

    List<BaseballNumber> ballNumbers;

    BaseballNumbers(String numberString) {
        validateSize(numberString);
        createBaseballNumber(numberString);
    }

    private void validateSize(String uncheckNumbers) {
        if (uncheckNumbers.length() != 3) {
            throw new IllegalArgumentException(INPUT_SIZE_ERROR);
        }
    }

    private void createBaseballNumber(String uncheckNumbers) {
        for (int index = 0; index < uncheckNumbers.length(); index++) {
            char uncheckNumber = uncheckNumbers.charAt(index);
            BaseballNumber baseballNumber = new BaseballNumber(uncheckNumber);
            ballNumbers.add(baseballNumber);
        }
    }
}
