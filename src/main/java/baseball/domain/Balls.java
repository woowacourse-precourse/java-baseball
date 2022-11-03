package baseball.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Balls {

    private final List<Ball> balls;

    private Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public static Balls createBalls(List<Integer> ballNumbers) {
        return new Balls(ballNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toUnmodifiableList()));
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
