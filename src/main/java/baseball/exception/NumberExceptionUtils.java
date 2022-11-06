package baseball.exception;

import baseball.domain.Command;

import static baseball.exception.ExceptionMessage.*;

public class NumberExceptionUtils {

    public static void isNotDuplicateNumber(String num) {
        if (num.chars().distinct().count() != 3) {
            throw new IllegalArgumentException(DUPLICATE_DIGIT_EXCEPTION.message());
        }
    }

    public static void isThreeDigits(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException(INVALID_DIGIT_EXCEPTION.message());
        }
    }

    public static void isPositiveDigits(String num) {
        if (Integer.parseInt(num) < 0) {
            throw new IllegalArgumentException(NEGATIVE_DIGIT_EXCEPTION.message());
        }
    }

    public static void isValidCommandDigit(String num) {
        if (!Command.hasValue(num)) {
            throw new IllegalArgumentException(INVALID_COMMAND_DIGIT_EXCEPTION.message());
        }
    }
}
