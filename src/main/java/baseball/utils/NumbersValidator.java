package baseball.utils;

import baseball.system.Constant;
import java.util.HashSet;
import java.util.List;

public final class NumbersValidator {
    
    public static final String NOT_UNIQUE_EXCEPTION = "서로 다른 숫자 3개를 입력해주세요.";
    public static final String INVALID_RANGE_EXCEPTION = "1에서 9까지의 숫자 3개를 입력해주세요.";

    private NumbersValidator() {

    }

    public static void isInCorrectRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constant.NUMBERS_LOWER_BOUND || number > Constant.NUMBERS_UPPER_BOUND) {
                throw new IllegalArgumentException(INVALID_RANGE_EXCEPTION);
            }
        }
    }

    public static void isAllDifferent(List<Integer> numbers) {
        if ((new HashSet<>(numbers)).size() != Constant.NUMBERS_SIZE) {
            throw new IllegalArgumentException(NOT_UNIQUE_EXCEPTION);
        }
    }
}
