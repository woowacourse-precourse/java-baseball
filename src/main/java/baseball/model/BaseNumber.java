package baseball.model;

import java.util.List;

public class BaseNumber {
    private final List<Integer> numbers;

    public BaseNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(int value) {
        return numbers.contains(value);
    }

    public int get(int index) {
        return numbers.get(index);
    }
}
