package baseball.model;

import java.util.Objects;

public class Ball {
    private final int number;
    private final int position;
    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public boolean isBall(Ball other) {
        return this.number == other.number && this.position != other.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball1 = (Ball) o;
        return number == ball1.number && position == ball1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }
}
