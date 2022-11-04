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
            if (appearances[number]) {
                throw new IllegalArgumentException("숫자는 중복되면 안됩니다");
            }
            if (!appearances[number]) {
                appearances[number] = true;
            }
        }
    }

    public int compareStrikes(Numbers other) {
        int strikes = 0;
        for (Integer number : numbers) {
            if (!other.contains(number)) {
                continue;
            }
            if (other.indexOf(number) == this.indexOf(number)) {
                strikes += 1;
            }
        }
        return strikes;
    }

    public int compareBalls(Numbers other) {
        int balls = 0;
        for (Integer number : numbers) {
            if (!other.contains(number)) {
                continue;
            }
            if (other.indexOf(number) != this.indexOf(number)) {
                balls += 1;
            }
        }
        return balls;
    }

    private boolean contains(Integer number) {
        return numbers.contains(number);
    }

    private int indexOf(Integer number) {
        return numbers.indexOf(number);
    }
}
