package baseball.domain.number;

import baseball.system.Constant;
import baseball.utils.NumbersValidator;
import java.util.List;

public class BaseballNumbers {
    private final List<Integer> numbers;

    public BaseballNumbers(List<Integer> numbers) throws IllegalArgumentException {
        validate(numbers);
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int countStrike(BaseballNumbers other) {
        int strikeCount = 0;
        for (int i = 0; i < Constant.NUMBERS_SIZE; i++) {
            if (numbers.get(i) == other.getNumbers().get(i)) {
                strikeCount++;
            }
        }
        return strikeCount;
    }

    public int countBall(BaseballNumbers other) {
        return countSameNumber(other) - countStrike(other);
    }

    private int countSameNumber(BaseballNumbers other) {
        int sameCount = 0;
        for (int number : other.getNumbers()) {
            if (numbers.contains(number)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        NumbersValidator.isInCorrectRange(numbers);
        NumbersValidator.isAllDifferent(numbers);
    }
}
