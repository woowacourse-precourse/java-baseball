package baseball;

import java.util.HashMap;
import java.util.regex.Pattern;

public class Validation {

    private static final String USER_NUMBER_RANGE = "^[1-9]{3}";
    private static final int USER_NUMBER_DIGIT_SIZE = 3;

    private static final String RESTART_NUMBER_RANGE = "^[1-2]{1}";
    private static final int RESTART_NUMBER_DIGIT_SIZE = 1;

    private static final String RANGE_ERROR_MESSAGE = "Number is out of range";
    private static final String DIGIT_ERROR_MESSAGE = "Number must be digit";
    private static final String SIZE_ERROR_MESSAGE = "Number must be correct-digit size: ";
    private static final String DUPLICATION_ERROR_MESSAGE = "UserNumber has duplicate number";

    public static void validateRestartNumber(String restartNumber) {
        validateDigit(restartNumber);
        validateSize(restartNumber, RESTART_NUMBER_DIGIT_SIZE);
        validateRange(restartNumber, RESTART_NUMBER_RANGE);
    }

    public static void validateUserNumber(String userNumbers) {
        validateDigit(userNumbers);
        validateSize(userNumbers, USER_NUMBER_DIGIT_SIZE);
        validateRange(userNumbers, USER_NUMBER_RANGE);
        validateDuplication(userNumbers);
    }

    private static void validateRange(String numbers, String regex) {

        if (!Pattern.matches(regex, numbers)) {
            throw new IllegalArgumentException(RANGE_ERROR_MESSAGE);
        }
    }

    private static void validateDigit(String numbers) {
        for (char number : numbers.toCharArray()) {
            checkDigit(number);
        }
    }

    private static void checkDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(DIGIT_ERROR_MESSAGE);
        }
    }


    private static void validateSize(String numbers, int digitSize) {
        if (numbers.length() != digitSize) {
            throw new IllegalArgumentException(SIZE_ERROR_MESSAGE + digitSize);
        }
    }

    private static void validateDuplication(String numbers) {
        HashMap<Character, Integer> checkMap = new HashMap<>();

        for (char number : numbers.toCharArray()) {
            checkMap.put(number, checkMap.getOrDefault(number, 0) + 1);
        }

        if (checkMap.containsValue(2) || checkMap.containsValue(3)) {
            throw new IllegalArgumentException(DUPLICATION_ERROR_MESSAGE);
        }
    }
}
