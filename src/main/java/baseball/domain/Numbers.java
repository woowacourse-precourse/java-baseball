package baseball.domain;

import baseball.utils.Constants;
import baseball.utils.ExceptionMessage;
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

    // 자리수 무관 일치하는 숫자 개수
    public int countSameNumber(Numbers other) {
        int sameCount = 0;
        for (int number : other.getNumbers()) {
            if (numbers.contains(number)) {
                sameCount++;
            }
        }
        return sameCount;
    }

    // 자리수까지 일치하는 숫자 개수
    public int countCorrectNumber(Numbers other) {
        int correctCount = 0;
        for (int i = 0; i < Constants.NUMBERS_SIZE; i++) {
            if (numbers.get(i) == other.getNumbers().get(i)) {
                correctCount++;
            }
        }
        return correctCount;
    }

    private void validate(List<Integer> numbers) throws IllegalArgumentException {
        isInCorrectRange(numbers);
        isAllDifferent(numbers);
    }

    private void isInCorrectRange(List<Integer> numbers) {
        for (int number : numbers) {
            if (number < Constants.NUMBERS_LOWER_BOUND || number > Constants.NUMBERS_UPPER_BOUND) {
                throw new IllegalArgumentException(ExceptionMessage.INVALID_RANGE_EXCEPTION);
            }
        }
    }

    private void isAllDifferent(List<Integer> numbers) {
        if ((new HashSet<>(numbers)).size() != Constants.NUMBERS_SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.NOT_UNIQUE_EXCEPTION);
        }
    }
}
