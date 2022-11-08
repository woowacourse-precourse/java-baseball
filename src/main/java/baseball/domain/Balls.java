package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private static final int MAX_BALLS_SIZE = Config.MAX_BALLS_SIZE;

    private final List<Ball> balls;

    public Balls(List<Integer> numbers) {
        validate(numbers);
        this.balls = numbers.stream()
                .map(Ball::fromNumber)
                .collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (isOutOfBounds(numbers)) throw new IllegalArgumentException("Numbers is out of bounds");
        if (isDuplicate(numbers)) throw new IllegalArgumentException("Numbers is duplicate");
    }

    private boolean isOutOfBounds(List<Integer> numbers) {
        return numbers.size() != MAX_BALLS_SIZE;
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() != numbers.size();
    }
}
