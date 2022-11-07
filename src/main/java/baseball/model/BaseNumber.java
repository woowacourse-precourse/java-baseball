package baseball.model;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseNumber that = (BaseNumber) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
