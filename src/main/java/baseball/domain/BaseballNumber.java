package baseball.domain;

import java.util.HashMap;

public class BaseballNumber {
    public static final int BASEBALL_NUMBER_LOWER_BOUND = 1;
    public static final int BASEBALL_NUMBER_UPPER_BOUND = 9;
    private static final HashMap<Integer, BaseballNumber> CACHE = new HashMap<>();

    static {
        for (int i = BASEBALL_NUMBER_LOWER_BOUND; i <= BASEBALL_NUMBER_UPPER_BOUND; i++) {
            CACHE.putIfAbsent(i, new BaseballNumber(i));
        }
    }

    private Integer number;

    private BaseballNumber(Integer number) {
        validate(number);
        this.number = number;
    }

    public static BaseballNumber valueOf(Integer number) {
        validate(number);
        return CACHE.get(number);
    }

    private static void validate(Integer number) {
        if (number < BASEBALL_NUMBER_LOWER_BOUND || BASEBALL_NUMBER_UPPER_BOUND < number) {
            throw new BaseballGameException();
        }
    }
}
