package baseball.vo;

import java.util.List;

public class UserNumber {
    private final List<Integer> numbers;

    private UserNumber(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static UserNumber of(List<Integer> numbers) {
        return new UserNumber(numbers);
    }

    public int size() {
        return numbers.size();
    }

    public Integer get(int index) {
        return numbers.get(index);
    }
}
