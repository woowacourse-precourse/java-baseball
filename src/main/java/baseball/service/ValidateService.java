package baseball.service;

public class ValidateService {

    public static final int RIGHT_SIZE = 3;

    public void validateInputValue(String inputBaseBallNumbers) {
        if (isOverOrUnderSize(inputBaseBallNumbers)) {
            throw new IllegalArgumentException("3자리 수의 정수만 가능합니다.");
        }
        if (isNotNumber(inputBaseBallNumbers)) {
            throw new IllegalArgumentException("숫자만 입력 가능합니다.");
        }
    }

    private boolean isNotNumber(String inputBaseBallNumbers) {
        return !inputBaseBallNumbers.chars().allMatch(Character::isDigit);
    }

    private boolean isOverOrUnderSize(String inputBaseBallNumbers) {
        return inputBaseBallNumbers.length() != RIGHT_SIZE;
    }

    public int validateInputNumber(int inputRestartNumber) {
        if (!(inputRestartNumber == 1 || inputRestartNumber == 2)) {
            throw new IllegalArgumentException();
        }
        return inputRestartNumber;
    }

}
