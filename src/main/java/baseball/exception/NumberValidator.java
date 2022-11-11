package baseball.exception;

import baseball.domain.GameStatus;

import static baseball.common.Constant.REG_EXP_DIGITS;
import static baseball.exception.NumberExceptionMessage.*;

public class NumberValidator {

    public static void isNotDuplicateDigits(String number) {
        if (number.chars().distinct().count() != 3) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_DIGIT_EXCEPTION.message());
        }
    }

    public static void isThreeDigits(String number) {
        if (number.length() != 3) {
            throw new IllegalArgumentException(INPUT_INVALID_DIGIT_LENGTH_EXCEPTION.message());
        }
    }

    public static void isPositiveDigits(String number) {
        if (!number.matches(REG_EXP_DIGITS)) {
            throw new IllegalArgumentException(INPUT_INVALID_DIGIT_EXCEPTION.message());
        }
    }

    public static void isValidCommandDigit(String num) {
        if (!GameStatus.hasValue(num)) {
            throw new IllegalArgumentException(INPUT_COMMAND_DIGIT_EXCEPTION.message());
        }
    }
}
