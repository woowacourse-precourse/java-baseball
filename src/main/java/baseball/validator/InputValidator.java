package baseball.validator;

import baseball.exception.InputException;

public class InputValidator {

    private static final String INTEGER_REGULAR_EXPRESSION = "^[0-9]*$";
    private static final int CORRECT_INPUT_LENGTH = 3;

    public static void validateInputForm(String guessedAnswer) {
        validateNotIntegerInput(guessedAnswer);
        validateNotThreeLengthIntegerInput(guessedAnswer);
    }

    public static void validateNotIntegerInput(String guessedAnswer) {
        if (!guessedAnswer.matches(INTEGER_REGULAR_EXPRESSION)) {
            InputException.throwNotIntegerInputError();
        }
    }

    public static void validateNotThreeLengthIntegerInput(String guessedAnswer) {
        if (guessedAnswer.length() != CORRECT_INPUT_LENGTH) {
            InputException.throwNotThreeLengthIntegerInputError();
        }
    }
}
