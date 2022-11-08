package baseball.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.regex.Pattern;

public class ValidateNumberService {

    private final static String ERROR_DIGIT_RANGE_NOT_FROM_ONE_TO_NINE = "Input이 숫자 1에서 9까지 범위가 아닙니다.";
    private final static String ERROR_DUPLICATED_DIGIT = "중복된 숫자가 존재합니다. ";
    private final static String ERROR_NUMBER_LENGTH_NOT_THREE = "Input의 길이가 3이 아닙니다.";
    private final static String ERROR_RESTART_INPUT_NOT_ONE_OR_TWO = "Restart Input이 1 혹은 2가 아닙니다.";

    public static void validateUserInput(String userInput) throws IllegalArgumentException {
        validateDigitRangeFromOneToNine(userInput);
        validateDuplicatedDigitExists(userInput);
        validateNumberLengthThree(userInput);
    }

    public static void validateRestartInput(String restartInput) {
        if (!(restartInput.equals("1") || restartInput.equals("2"))) {
            throw new IllegalArgumentException(ERROR_RESTART_INPUT_NOT_ONE_OR_TWO);
        }
    }

    private static void validateDigitRangeFromOneToNine(String userInput) {
        if (!Pattern.matches("^[1-9]*$", userInput)) {
            throw new IllegalArgumentException(ERROR_DIGIT_RANGE_NOT_FROM_ONE_TO_NINE);
        }
    }

    private static void validateDuplicatedDigitExists(String userInput) {
        List<String> digits = new ArrayList<>(Arrays.asList(userInput.split("")));
        HashSet<String> set = new HashSet<>();
        for (String digit : digits) {
            set.add(digit);
        }
        if (set.size() != 3) {
            throw new IllegalArgumentException(ERROR_DUPLICATED_DIGIT);
        }
    }

    private static void validateNumberLengthThree(String userInput) {
        if (userInput.length() != 3) {
            throw new IllegalArgumentException(ERROR_NUMBER_LENGTH_NOT_THREE);
        }
    }

}
