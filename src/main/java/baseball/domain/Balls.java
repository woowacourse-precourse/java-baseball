package baseball.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Balls {

    public static final int BALLS_FORMAL_SIZE = 3;
    private static final String BALLS_SIZE_EXCEPTION_MESSAGE = "입력은 " + BALLS_FORMAL_SIZE + "자리만 가능합니다.";
    private static final String DUPLICATION_NUMBER_EXCEPTION_MESSAGE = "중복되지 않은 숫자만 입력 가능합니다.";
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = sizeValidate(balls);
    }

    public static Balls createBalls(List<Integer> ballNumbers) {
        return new Balls(duplicateValidate(ballNumbers).stream()
                .map(Ball::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    private List<Ball> sizeValidate(List<Ball> balls) {
        if (balls.size() == BALLS_FORMAL_SIZE) {
            return balls;
        }
        throw new IllegalArgumentException(BALLS_SIZE_EXCEPTION_MESSAGE);
    }

    private static List<Integer> duplicateValidate(List<Integer> numbers) {
        Set<Integer> balls = new HashSet<>(numbers);
        if (balls.size() == numbers.size()) {
            return numbers;
        }
        throw new IllegalArgumentException(DUPLICATION_NUMBER_EXCEPTION_MESSAGE);
    }

    public int getSize() {
        return balls.size();
    }

    public Ball getBall(int index) {
        return balls.get(index);
    }

    public boolean isContain(Ball ball) {
        return balls.contains(ball);
    }
}
