package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    public static final int BALLS_FORMAL_SIZE = 3;
    public static final String BALLS_SIZE_EXCEPTION_MESSAGE = "입력은 3자리만 가능합니다.";
    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = sizeValidate(balls);
    }

    public static Balls createBalls(List<Integer> ballNumbers) {
        return new Balls(ballNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toUnmodifiableList()));
    }

    private List<Ball> sizeValidate(List<Ball> balls) {
        if (balls.size() == BALLS_FORMAL_SIZE) {
            return balls;
        }
        throw new IllegalArgumentException(BALLS_SIZE_EXCEPTION_MESSAGE);
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
