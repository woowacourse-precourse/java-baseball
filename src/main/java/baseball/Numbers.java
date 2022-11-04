package baseball;

import java.util.ArrayList;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validateLength(numbers);
        validateNoDuplicates(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자는 3자리여야 합니다");
        }
    }

    private void validateNoDuplicates(List<Integer> numbers) {
        boolean[] appearances = new boolean[10];
        for (Integer number : numbers) {
            if (!appearances[number]) {
                appearances[number] = true;
            }
            if (appearances[number]) {
                throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
            }
        }
    }
}
