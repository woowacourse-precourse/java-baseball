package baseball.numbers;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Number {
    private static final Map<Integer, Number> numbers = new HashMap<>();
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;

    private final int number;

    static {
        IntStream.range(MIN_NUMBER, MAX_NUMBER + 1)
                .forEach(number -> numbers.put(number, new Number(number)));
    }

    private Number(int number) {
        this.number = number;
    }

    public static Number from(String number) {
        return from(Integer.parseInt(number));
    }

    public static Number from(int number) {
        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new IllegalArgumentException();
        }
        return numbers.get(number);
    }
}
