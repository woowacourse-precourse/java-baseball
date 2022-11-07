package baseball.util;

import static baseball.Constants.EXIT;
import static baseball.Constants.MAX_RANGE;
import static baseball.Constants.MIN_RANGE;
import static baseball.Constants.START;
import static baseball.Constants.TRIPLE_DIGITS;
import static baseball.Constants.USER_INPUT_HAS_DUPLICATED_NUMBER;
import static baseball.Constants.USER_INPUT_IS_NOT_IN_RANGE;
import static baseball.Constants.USER_INPUT_IS_NOT_THREE_DIGITS;
import static baseball.Constants.USER_INPUT_IS_NULL_OR_EMPTY;
import static baseball.Constants.USER_INPUT_RANGE_ERROR;
import static baseball.Constants.USER_INPUT_TYPE_ERROR;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public static void validateUserInputIsNullOrEmpty(String userInput) {
        if (userInput == null || userInput.isEmpty()) {
            throw new IllegalArgumentException(USER_INPUT_IS_NULL_OR_EMPTY);
        }
    }

    public static void validateUserInputIsThreeDigits(String userInput) {
        if (userInput.length() != TRIPLE_DIGITS) {
            throw new IllegalArgumentException(USER_INPUT_IS_NOT_THREE_DIGITS);
        }
    }

    public static void validateUserInputIsMinRangeToMaxRange(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';
            if (!(MIN_RANGE <= userInputIntValue && userInputIntValue <= MAX_RANGE)) {
                throw new IllegalArgumentException(USER_INPUT_IS_NOT_IN_RANGE);
            }
        }
    }

    public static void validateUserInputHasDuplicateNumber(String userInput) {
        Set<Integer> set = new HashSet<>();
        for (int index = 0; index < userInput.length(); index++) {
            int userInputIntValue = userInput.charAt(index) - '0';

            if (set.contains(userInputIntValue)) {
                throw new IllegalArgumentException(USER_INPUT_HAS_DUPLICATED_NUMBER);
            }

            set.add(userInputIntValue);
        }
    }

    public static void validateUserInputType(String userInput) {
        try {
            Integer.parseInt(userInput);
        } catch (Exception e) {
            throw new IllegalArgumentException(USER_INPUT_TYPE_ERROR);
        }
    }

    public static void validateUserInputIsStartOrExit(int userInput) {
        if (START > userInput || userInput > EXIT) {
            throw new IllegalArgumentException(USER_INPUT_RANGE_ERROR);
        }
    }
}
