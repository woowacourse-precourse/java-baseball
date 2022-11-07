package baseball.exception;

import java.util.regex.Pattern;

public class InputException {
    private InputException() {}

    public static void isNumber(String inputNumbers) {
        if(!Pattern.matches("^[0-9]*$", inputNumbers)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
    }

    public static void isLength(String inputNumbers) {
        if(inputNumbers.length() != 3) {
            throw new IllegalArgumentException("숫자의 길이가 맞지 않습니다.");
        }
    }
}
