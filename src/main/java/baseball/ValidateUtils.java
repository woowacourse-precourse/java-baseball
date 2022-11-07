package baseball;

import java.util.List;

public class ValidateUtils {

    private static final String INPUT_LENGTH_ERROR = "입력값은 %s 자여야 합니다.";
    private static final String INPUT_RANGE_ERROR = "입력값은 1 ~ 9 사이의 값이어야 합니다.";
    private static final String INPUT_DUPLICATE_ERROR = "중복된 값이 존재합니다.";
    private static final String INPUT_GAME_OVER_ERROR = "입력값은 1 또는 2 의 값이어야 합니다.";

    public static void checkInputLength(int length, int maxLength) {
        if (length != maxLength) {
            throw new IllegalArgumentException(String.format(INPUT_LENGTH_ERROR, maxLength));
        }
    }

    public static void checkInputRangeNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException(INPUT_RANGE_ERROR);
        }
    }

    public static void checkDuplicateInput(List<Integer> numbers, int number) {
        if (numbers.contains(number)) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR);
        }
    }

    public static void checkGameOverInput(int number) {
        if (number < 1 || number > 2) {
            throw new IllegalArgumentException(INPUT_GAME_OVER_ERROR);
        }
    }
}
