package baseball.domain;

import baseball.utils.ErrorMessage;

import java.util.List;

import static baseball.utils.BaseBallStatus.BASEBALL_DEFAULT_SIZE;

public class Answer {

    private final List<Integer> numbers;

    public Answer(List<Integer> numbers) {
        validateAnswer(numbers);
        this.numbers = numbers;
    }

    private void validateAnswer(List<Integer> numbers) {
        if (numbers.size() != BASEBALL_DEFAULT_SIZE.getCode()) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BASEBALL_SIZE.getMessage());
        }
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
