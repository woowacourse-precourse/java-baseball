package baseball.service;

import java.util.stream.IntStream;

public class ValidateService {

    public void validateInputValue(String inputBaseBallNumbers) {
        if (isOverSize(inputBaseBallNumbers)) {
            throw new IllegalStateException("3자리 수의 정수만 가능합니다.");
        }
        if (isNotNumber(inputBaseBallNumbers)) {
            throw new IllegalStateException("숫자만 입력 가능합니다.");
        }
    }

    private boolean isNotNumber(String inputBaseBallNumbers) {
        return !inputBaseBallNumbers.chars().allMatch(Character::isDigit);
    }

    private boolean isOverSize(String inputBaseBallNumbers) {
        return inputBaseBallNumbers.length() > 3;
    }


}
