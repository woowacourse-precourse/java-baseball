package baseball;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Player {

    public static final int CRITERION_NUMBER_SIZE = 3;
    public static final String NUMBER_SIZE_EX_MESSAGE = "입력값은 3개의 숫자여야 합니다.";

    private final List<Ball> balls;

    public Player(List<Integer> numbers) {
        validateNumbers(numbers);
        balls = mapToBall(numbers);
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != CRITERION_NUMBER_SIZE) {
            throw new IllegalArgumentException(NUMBER_SIZE_EX_MESSAGE);
        }
    }

    private List<Ball> mapToBall(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> new Ball(new AtomicInteger().getAndIncrement(), number))
                .collect(Collectors.toList());
    }
}