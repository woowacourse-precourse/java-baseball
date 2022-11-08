package baseball.validator;

import baseball.exception.InputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class InputValidator {

    private static final String INTEGER_REGULAR_EXPRESSION = "^[0-9]*$";
    private static final String RESTART_COMMAND = "1";
    private static final String STOP_COMMAND = "2";
    private static final String ZERO = "0";
    private static final int CORRECT_INPUT_LENGTH = 3;

    private static String guessedAnswerInput;

    public static void validateInputForm(String guessedAnswer) {
        guessedAnswerInput = guessedAnswer;

        validateNotIntegerInput();
        validateNotThreeLengthIntegerInput();
        validateIncludeZeroInput();
        validateDuplicateNumberInput();
    }

    public static void validateNotIntegerInput() {
        if (guessedAnswerInput.matches(INTEGER_REGULAR_EXPRESSION)) {
            return;
        }

        InputException.throwNotIntegerInputError();
    }

    public static void validateNotThreeLengthIntegerInput() {
        if (guessedAnswerInput.length() == CORRECT_INPUT_LENGTH) {
            return;
        }

        InputException.throwNotThreeLengthIntegerInputError();
    }

    public static void validateIncludeZeroInput() {
        if (guessedAnswerInput.contains(ZERO)) {
            InputException.throwIncludeZeroInputError();
        }
    }

    public static void validateDuplicateNumberInput() {
        List<Character> guessedAnswerInputList = new ArrayList<>();
        Set<Character> guessedAnswerInputSet = new HashSet<>();

        for (char number : guessedAnswerInput.toCharArray()) {
            guessedAnswerInputList.add(number);
            guessedAnswerInputSet.add(number);
        }

        if (guessedAnswerInputList.size() == guessedAnswerInputSet.size()) {
            return;
        }

        InputException.throwDuplicateNumberInputError();
    }

    public static void validCommandForm(String command) {
        if (command.equals(RESTART_COMMAND)) {
            return;
        }

        if (command.equals(STOP_COMMAND)) {
            return;
        }

        InputException.throwNotOneOrTwoInputError();
    }
}
