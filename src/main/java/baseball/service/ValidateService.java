package baseball.service;

public class ValidateService {

    public void validateInputValue(String inputBaseBallNumbers) {
        if (isOverSize(inputBaseBallNumbers)) {
            throw new IllegalArgumentException("3자리 수의 정수만 가능합니다.");
        }
        if (isNotNumber(inputBaseBallNumbers)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private boolean isNotNumber(String inputBaseBallNumbers) {
        return !inputBaseBallNumbers.chars().allMatch(Character::isDigit);
    }

    private boolean isOverSize(String inputBaseBallNumbers) {
        return inputBaseBallNumbers.length() > 3;
    }

    public int validateInputNumber(int inputRestartNumber) {
        if (!(inputRestartNumber == 1 || inputRestartNumber == 2)) {
            throw new IllegalArgumentException();
        }
        return inputRestartNumber;
    }

}
