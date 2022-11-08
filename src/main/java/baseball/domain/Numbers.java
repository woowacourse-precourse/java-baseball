package baseball.domain;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<Number> numbers;

    private Numbers() {
    }

    public Numbers(List<Number> numbers) {
        validateSize(numbers);
        validateDuplication(numbers);
        this.numbers = new ArrayList<>(numbers);
    }

    private void validateSize(List<Number> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("3자리 수가 아닙니다.");
        }
    }

    private void validateDuplication(List<Number> numbers) {
        int uniqueCount = (int) numbers.stream().distinct().count();
        if (numbers.size() != uniqueCount) {
            throw new IllegalArgumentException("같은 수가 포함되었습니다.");
        }
    }
}
