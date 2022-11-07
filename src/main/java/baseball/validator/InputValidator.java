package baseball.validator;

import baseball.exception.InputException;

public class InputValidator {

    private static final String INTEGER_REGULAR_EXPRESSION = "^[0-9]*$";

    public static void validateInputForm(String guessedAnswer) {
        validateNotIntegerInput(guessedAnswer);
    }

    public static void validateNotIntegerInput(String guessedAnswer) {
        if (!guessedAnswer.matches(INTEGER_REGULAR_EXPRESSION)) {
            InputException.throwNotIntegerInputError();
        }
    }
}
