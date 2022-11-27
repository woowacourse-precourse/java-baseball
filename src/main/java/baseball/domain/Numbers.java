package baseball.domain;

import baseball.utils.Constants;
import java.util.HashSet;
import java.util.List;

public class Numbers {

    private final List<Integer> numbers;

    public Numbers(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        isInCorrectRange(numbers);
        isAllDifferent(numbers);
    }

    private void isInCorrectRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.NUMBERS_LOWER_BOUND || number > Constants.NUMBERS_UPPER_BOUND) {
                // TODO exception 메세지 추가
                throw new IllegalArgumentException();
            }
        }
    }

    private void isAllDifferent(List<Integer> numbers) {
        if ((new HashSet<>(numbers)).size() != Constants.NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }
}
