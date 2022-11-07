package baseball.exception;

import java.util.regex.Pattern;

import static baseball.constant.Constant.*;

public class InputException {
    private InputException() {}

    public static void isNumber(String inputNumbers) {
        if(!Pattern.matches("^[0-9]*$", inputNumbers)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static void isLength(String inputNumbers) {
        if(inputNumbers.length() != RANDOM_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("숫자의 길이가 맞지 않습니다.");
        }
    }
}
