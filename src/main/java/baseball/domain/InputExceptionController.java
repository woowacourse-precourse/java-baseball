package baseball.domain;

import baseball.validation.InputValidation;

public class InputExceptionController {
    private final InputValidation inputValidation = new InputValidation();

    public void checkPlayerNumbersInputException(String input) {
        if (inputValidation.isNotThreeLetters(input)
                || inputValidation.isNot1To9(input)
                || inputValidation.hasDuplicatedValues(input)) {
            throw new IllegalArgumentException("1부터 9까지 서로 다른 3자리 수를 입력해야 합니다.");
        }
    }

    public void checkRestartInputException(String input) {
        if (inputValidation.isNotCorrectChoice(input)) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }
}
