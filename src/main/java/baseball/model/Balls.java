package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final int BALLS_MAX_SIZE = 3;
    private final List<Integer> balls;
    public Balls(List<Integer> balls) {
        this.balls = balls;
    }

    private void validateDuplicate(List<Integer> balls) {
        Set<Integer> set = new HashSet<>(balls);
        if (set.size() != balls.size()) {
            throw new IllegalArgumentException();
        }
    }

    public void addBall(int number) {
        if (balls.contains(number)) {
            return;
        }
        balls.add(number);
        validateDuplicate(balls);
    }

    public boolean isSize(int size) {
        return balls.size() == size;
    }
}
