package baseball.exception;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import static baseball.constant.Constant.*;

public class InputException {
    private static final String NOT_NUMBER = "숫자가 아닙니다.";
    private static final String NOT_NUMBER_LENGTH = "숫자의 길이가 맞지 않습니다.";

    private InputException() {
    }

    public static void isNumber(String inputNumbers) {
        if (!Pattern.matches("^[0-9]*$", inputNumbers)) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
    }

    public static void isLength(String inputNumbers) {
        if (inputNumbers.length() != RANDOM_NUMBERS_LENGTH) {
            throw new IllegalArgumentException(NOT_NUMBER_LENGTH);
        }
    }

    public static void isDuplicate(String inputNumbers) {
        List<String> inputNumberList = Arrays.asList(inputNumbers.split(""));
        if (inputNumberList.stream().distinct().count() < RANDOM_NUMBERS_LENGTH) {
            throw new IllegalArgumentException("중복된 숫자가 있습니다.");
        }
    }
}
