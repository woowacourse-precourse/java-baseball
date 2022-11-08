package baseball.model;

import java.util.Objects;

public class Ball {
    int number;

    public Ball(int number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Ball ball = (Ball) o;
        return number == ball.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
