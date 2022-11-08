package baseball.utils;

import static baseball.BaseballGame.INPUT_SIZE;

public class InputValidator {

    public void validateBallNumberString(String input) throws IllegalArgumentException {
        validateIntegerRange(input);
        validateInputLength(input);
        validateInputDistinct(input);
    }

    private void validateIntegerRange(String input) throws IllegalArgumentException {
        if (input.chars().anyMatch(number -> number < '0' || number > '9')) {
            throw new IllegalArgumentException("입력이 [0, 9]사이의 숫자 이외의 문자를 포함합니다.");
        }
    }

    private void validateInputLength(String input) throws IllegalArgumentException {
        if (input.length() != INPUT_SIZE) {
            throw new IllegalArgumentException(String.format("입력한 숫자의 길이가 %d이 아닙니다.", INPUT_SIZE));
        }
    }

    private void validateInputDistinct(String input) throws IllegalArgumentException {
        if (input.chars().distinct().count() != INPUT_SIZE) {
            throw new IllegalArgumentException("입력한 숫자에 중복이 발생했습니다.");
        }
    }
}
