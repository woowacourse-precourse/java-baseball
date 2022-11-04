package baseball.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public boolean compare(Ball other) {
        for (Ball ball : balls) {
            if (Objects.equals(ball, other)) {
                return true;
            }
        }
        return false;
    }
}
