package baseball.validator;

import baseball.exception.InputException;

public class InputValidator {

    private static final String INTEGER_REGULAR_EXPRESSION = "^[0-9]*$";
    private static final String ZERO = "0";
    private static final int CORRECT_INPUT_LENGTH = 3;
    private static String guessedAnswerInput;

    public static void validateInputForm(String guessedAnswer) {
        guessedAnswerInput = guessedAnswer;

        validateNotIntegerInput();
        validateNotThreeLengthIntegerInput();
        validateIncludeZeroInput();
    }

    public static void validateNotIntegerInput() {
        if (!guessedAnswerInput.matches(INTEGER_REGULAR_EXPRESSION)) {
            InputException.throwNotIntegerInputError();
        }
    }

    public static void validateNotThreeLengthIntegerInput() {
        if (guessedAnswerInput.length() != CORRECT_INPUT_LENGTH) {
            InputException.throwNotThreeLengthIntegerInputError();
        }
    }

    public static void validateIncludeZeroInput() {
        if (guessedAnswerInput.contains(ZERO)) {
            InputException.throwIncludeZeroInputError();
        }
    }
}
