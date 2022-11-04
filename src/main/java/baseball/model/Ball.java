package baseball.model;

import java.util.Objects;

public class Ball {
    private final int ball;
    private final int position;
    public Ball(int ball, int position) {
        this.ball = ball;
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return ball == ball1.ball && position == ball1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball, position);
    }
}
