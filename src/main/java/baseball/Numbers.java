package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateLength(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다");
        }
    }
}
