package baseball.domain;

import java.util.HashMap;
import java.util.Map;

public class Number {

    private static final int NUMBER_MIN = 1;
    private static final int NUMBER_MAX = 9;
    private static final String BOUND_EXCEPTION = "숫자의 범위는 " + NUMBER_MIN + "부터 " + NUMBER_MAX + "까지 입니다.";
    
    private static final Map<Integer, Number> numbers = new HashMap<>();
    private final int number;

    static {
        for (int number = NUMBER_MIN; number <= NUMBER_MAX; number++) {
            numbers.put(number, new Number(number));
        }
    }

    private Number(int number) {
        validateBound(number);
        this.number = number;
    }

    public static Number of(int number) {
        validateBound(number);
        return numbers.get(number);
    }

    private static void validateBound(int number) {
        if ((number < NUMBER_MIN) || (number > NUMBER_MAX)) {
            throw new IllegalArgumentException(BOUND_EXCEPTION);
        }
    }
}
