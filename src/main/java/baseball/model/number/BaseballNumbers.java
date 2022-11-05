package baseball.model.number;

import java.util.List;

public class BaseballNumbers {
    private static final String INPUT_SIZE_EXCEPTION = "입력하는 수는 3자리여야 합니다";
    private static final String DUPLICATE_NUMBER_EXCEPTION = "중복되지 않는 수를 입력해야 합니다";

    List<BaseballNumber> ballNumbers;

    BaseballNumbers(String numberString) {
        validateSize(numberString);
        createBaseballNumber(numberString);
        validateDuplicateNumbers();
    }

    public BaseballNumbers(List<Integer> ballNumbers) {
        createBaseballNumber(ballNumbers);
    }

    private void validateSize(String uncheckNumbers) {
        if (uncheckNumbers.length() != 3) {
            throw new IllegalArgumentException(INPUT_SIZE_EXCEPTION);
        }
    }

    private void createBaseballNumber(String uncheckNumbers) {
        for (int index = 0; index < uncheckNumbers.length(); index++) {
            char uncheckNumber = uncheckNumbers.charAt(index);
            BaseballNumber baseballNumber = new BaseballNumber(uncheckNumber);
            ballNumbers.add(baseballNumber);
        }
    }

    private void createBaseballNumber(List<Integer> numbers) {
        for(Integer number: numbers) {
            BaseballNumber baseballNumber = new BaseballNumber(number);
            ballNumbers.add(baseballNumber);
        }
    }

    private void validateDuplicateNumbers() {
        boolean isDuplicatedValue = false;
        for(int index = 0; index < ballNumbers.size(); index++) {
            BaseballNumber baseballNumber = ballNumbers.get(index);
            BaseballNumber nextBaseballNumber = ballNumbers.get(index+1);
            isDuplicatedValue = baseballNumber.equals(nextBaseballNumber);
        }

        if(isDuplicatedValue) {
            throw new IllegalArgumentException(DUPLICATE_NUMBER_EXCEPTION);
        }
    }
}
