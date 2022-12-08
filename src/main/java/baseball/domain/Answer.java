package baseball.domain;

import baseball.utils.BaseBallStatus;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.utils.BaseBallStatus.ANSWER_DEFAULT_SIZE;
import static baseball.utils.ErrorMessage.*;

public class Answer {

    private final List<Integer> numbers;

    public Answer(List<Integer> numbers) {
        validateAnswer(numbers);
        this.numbers = numbers;
    }

    private void validateAnswer(List<Integer> numbers) {
        if (isWrongSize(numbers)) {
            throw new IllegalArgumentException(INVALID_BASEBALL_SIZE.getMessage());
        }
        if (isDuplicated(numbers)) {
            throw new IllegalArgumentException(DUPLICATED_BASEBALL_NUMBER.getMessage());
        }
        if (isOutOfRange(numbers)) {
            throw new IllegalArgumentException(OUT_OF_RANGE_BASEBALL_NUMBER.getMessage());
        }
    }

    private boolean isWrongSize(List<Integer> numbers) {
        return numbers.size() != ANSWER_DEFAULT_SIZE.getCode();
    }

    private boolean isDuplicated(List<Integer> numbers) {
        Set<Integer> duplicateRemoved = new HashSet<>(numbers);
        return duplicateRemoved.size() != numbers.size();
    }

    private boolean isOutOfRange(List<Integer> numbers) {
        return numbers.stream()
                .anyMatch(BaseBallStatus::isOutOfRange);
    }

    public int get(int index) {
        return numbers.get(index);
    }

    public int size() {
        return numbers.size();
    }

    public boolean contains(int number) {
        return numbers.contains(number);
    }

}
