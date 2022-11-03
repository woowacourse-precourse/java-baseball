package baseball.domain;

import java.util.Objects;

public class Ball {

    private final int ball;

    public Ball(int ball) {
        this.ball = ball;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Ball ball1 = (Ball) o;
        return ball == ball1.ball;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ball);
    }
}
