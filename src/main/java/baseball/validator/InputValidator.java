package baseball.validator;

import baseball.exception.InputException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        validateDuplicateNumberInput();
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

    public static void validateDuplicateNumberInput() {
        List<Character> guessedAnswerInputList = new ArrayList<>();
        Set<Character> guessedAnswerInputSet = new HashSet<>();

        for (char number : guessedAnswerInput.toCharArray()) {
            guessedAnswerInputList.add(number);
            guessedAnswerInputSet.add(number);
        }

        if (guessedAnswerInputList.size() != guessedAnswerInputSet.size()) {
            InputException.throwDuplicateNumberInputError();
        }
    }
}
