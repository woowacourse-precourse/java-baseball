package baseball.exception;

import baseball.domain.GameStatus;

import static baseball.common.Constant.DIGITS;
import static baseball.exception.ExceptionMessage.*;

public class NumberValidator {

    public static void isNotDuplicateNumber(String number) {
        if (number.chars().distinct().count() != 3) {
            throw new IllegalArgumentException(DUPLICATE_DIGIT_EXCEPTION.message());
        }
    }

    public static void isThreeDigits(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException(INVALID_DIGIT_EXCEPTION.message());
        }
    }

    public static void isPositiveDigits(String number) {
        if (Integer.parseInt(number) <= 0) {
            throw new IllegalArgumentException(NEGATIVE_DIGIT_EXCEPTION.message());
        }
    }

    public static void isDigit(String number) {
        if (!number.matches(DIGITS)) {
            throw new IllegalArgumentException(INVALID_CHARACTER_EXCEPTION.message());
        }
    }

    public static void isValidCommandDigit(String num) {
        if (!GameStatus.hasValue(num)) {
            throw new IllegalArgumentException(INVALID_COMMAND_DIGIT_EXCEPTION.message());
        }
    }
}
