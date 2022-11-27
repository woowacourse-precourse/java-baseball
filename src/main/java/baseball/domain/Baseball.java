package baseball.domain;

import baseball.utils.Constants;
import java.util.HashSet;
import java.util.List;

public class Baseball {

    private final List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countStrike(Baseball baseball) {
        int strikeCount = 0;
        for (int i = 0; i < Constants.NUMBERS_SIZE; i++) {
            if (baseball.getNumbers().get(i) == this.numbers.get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(Baseball baseball) {
        int sameNumberCount = 0;
        for (int number : baseball.getNumbers()) {
            if (this.numbers.contains(number)) {
                sameNumberCount++;
            }
        }
        return sameNumberCount - countStrike(baseball);
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
