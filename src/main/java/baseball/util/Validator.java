package baseball.util;

import java.util.ArrayList;
import java.util.List;

public class Validator {

    private static final int REGULAR_NUMBERS_SIZE = 3;
    private static final int MIN_STRIKE_COUNT = 0;
    private static final int MAX_STRIKE_COUNT = 3;
    private static final int MIN_BALL_COUNT = 0;
    private static final int MAX_BALL_COUNT = 3;
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String RESTART_NUMBER = "1";
    private static final String END_NUMBER = "2";
    private static final String BALLCOUNT_FORMAT = "%s는 0에서 3 사이 숫자만 집계합니다";
    private static final String ONLY_INPUT_1_OR_2 = "1과 2만 입력 가능합니다";
    private static final String NUMBER_CANT_DUPLICATE = "숫자는 중복될 수 없습니다";
    private static final String NUMBER_SIZE_ONLY_THREE = "숫자는 3개만 입력 가능합니다";

    public static void validateNumbersDuplicate(List<Integer> numbers) {
        List<Integer> cachedNumbers = new ArrayList<>();
        for (Integer number : numbers) {
            if (cachedNumbers.contains(number)) {
                throw new IllegalArgumentException(NUMBER_CANT_DUPLICATE);
            }
            cachedNumbers.add(number);
        }
    }

    public static void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() < REGULAR_NUMBERS_SIZE || numbers.size() > REGULAR_NUMBERS_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_ONLY_THREE);
        }
    }

    public static void validateStrikeCount(int strikes) {
        if (strikes < MIN_STRIKE_COUNT || strikes > MAX_STRIKE_COUNT) {
            throw new IllegalArgumentException(String.format(BALLCOUNT_FORMAT, STRIKE));
        }
    }

    public static void validateBallCount(int balls) {
        if (balls < MIN_BALL_COUNT || balls > MAX_BALL_COUNT) {
            throw new IllegalArgumentException(String.format(BALLCOUNT_FORMAT, BALL));
        }
    }

    public static void validateWrongNum(String userInput) {
        if (!userInput.equals(RESTART_NUMBER) && !userInput.equals(END_NUMBER)) {
            throw new IllegalArgumentException(ONLY_INPUT_1_OR_2);
        }
    }

}
