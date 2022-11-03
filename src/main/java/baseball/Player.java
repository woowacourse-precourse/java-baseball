package baseball;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {

    public static final String NUMBER_SIZE_EX_MESSAGE = "입력값은 3개의 숫자여야 합니다.";
    public static final int CRITERION_NUMBER_SIZE = 3;

    public static final String NUMBER_SAME_EX_MESSAGE = "입력값은 같은 수가 하나라도 있으면 안됩니다.";
    public static final int NUMBER_INDEX_ZERO = 0;
    public static final int NUMBER_INDEX_ONE = 1;
    public static final int NUMBER_INDEX_TWO = 2;

    private final List<Ball> balls;

    public Player(List<Integer> numbers) {
        validateNumbers(numbers);
        balls = mapToBall(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        validateSize(numbers);
        validateSameNumber(numbers);
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != CRITERION_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EX_MESSAGE);
        }
    }

    private void validateSameNumber(List<Integer> numbers) {
        if (isSameNumber(numbers.get(NUMBER_INDEX_ZERO), numbers.get(NUMBER_INDEX_ONE))) {
            throw new IllegalArgumentException(NUMBER_SAME_EX_MESSAGE);
        }
        if (isSameNumber(numbers.get(NUMBER_INDEX_ZERO), numbers.get(NUMBER_INDEX_TWO))) {
            throw new IllegalArgumentException(NUMBER_SAME_EX_MESSAGE);
        }
        if (isSameNumber(numbers.get(NUMBER_INDEX_ONE), numbers.get(NUMBER_INDEX_TWO))) {
            throw new IllegalArgumentException(NUMBER_SAME_EX_MESSAGE);
        }
    }

    private boolean isSameNumber(Integer number, Integer otherNumber) {
        return number.equals(otherNumber);
    }

    private List<Ball> mapToBall(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new Ball(new AtomicInteger().getAndIncrement(), number))
                .collect(Collectors.toList());
    }
}