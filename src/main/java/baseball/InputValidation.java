package baseball;

import java.util.Collections;
import java.util.List;

public class InputValidation {
    private static final Integer START_NUMBER = 1;
    private static final Integer END_NUMBER = 9;

    private static final Character GAME_START_NUMBER = '1';
    private static final Character GAME_END_NUMBER = '2';

    private static final String INPUT_LENGTH_ERROR = "입력값은 %s자리 수가 아닙니다.";
    private static final String INPUT_RANGE_ERROR = "입력값은 %s ~ %s 범위의 수가 아닙니다.";
    private static final String INPUT_DUPLICATE_ERROR = "입력값은 서로 다른 수가 아닙니다.";
    private static final String INPUT_GAME_END_CHOICE_ERROR = "입력값은 %s또는 %s의 값이 아닙니다.";


    public static void checkNumberLength(String number, Integer maxLength) {
        if (number.length() != maxLength) {
            throw new IllegalArgumentException(String.format(INPUT_LENGTH_ERROR, maxLength));
        }
    }

    public static void checkNumberRange(Integer number) {
        if (number < START_NUMBER || number > END_NUMBER) {
            throw new IllegalArgumentException(String.format(INPUT_RANGE_ERROR, START_NUMBER, END_NUMBER));
        }
    }

    public static void checkDuplicateNumber(List<Integer> numbers, Integer targetNumber) {
        if (Collections.frequency(numbers, targetNumber) != 1) {
            throw new IllegalArgumentException(INPUT_DUPLICATE_ERROR);
        }
    }

    public static void checkGameEndChoiceNumber(String number) {
        checkNumberLength(number, 1);

        if (number.charAt(0) < GAME_START_NUMBER || number.charAt(0) > GAME_END_NUMBER) {
            throw new IllegalArgumentException(String.format(INPUT_GAME_END_CHOICE_ERROR, GAME_START_NUMBER, GAME_END_NUMBER));
        }
    }
}
