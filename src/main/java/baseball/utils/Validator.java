package baseball.utils;

import java.util.ArrayList;
import java.util.List;

import static baseball.utils.Constants.*;

public class Validator {
    public static final String NUMBER_NUMERIC_REGEX = "^[1-9]{3}$";
    public static final String RESTART_NUMERIC_REGEX = "^[1-2]{1}$";
    public static final String ZERO = "0";

    public static boolean validateNumberInput(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException(ErrorCode.NOT_NUMERIC_ONLY.getContent());
        }

        if (!isUniqueDigit(input)) {
            throw new IllegalArgumentException(ErrorCode.NOT_NUMERIC_ONLY.getContent());
        }

        if (isInvalidLength(input)) {
            throw new IllegalArgumentException(ErrorCode.INVALID_LENGTH.getContent());
        }

        if (isInvalidRange(input)) {
            throw new IllegalArgumentException(ErrorCode.DUPLICATE_NUMBER.getContent());
        }

        return true;
    }

    public static boolean validateRestartInput(String input) {
        if (input.matches(RESTART_NUMERIC_REGEX)) {
            return true;
        }

        throw new IllegalArgumentException();
    }

    private static boolean isNumeric(String input) {
        return input.matches(NUMBER_NUMERIC_REGEX);
    }

    private static boolean isInvalidLength(String input) {
        return input.length() != BASEBALL_DIGIT_LENGTH;
    }

    private static boolean isUniqueDigit(String input) {
        List<String> inputList = new ArrayList<>(List.of(input.split("")));

        long numCount = inputList.stream()
                .distinct()
                .count();

        return numCount == BASEBALL_DIGIT_LENGTH;
    }

    private static boolean isInvalidRange(String input) {
        return input.contains(ZERO);
    }
}
