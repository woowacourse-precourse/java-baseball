package baseball;

import java.util.Objects;

public class Ball {
    int number;

    public Ball(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        Ball ball = (Ball) o;
        return getNumber() == ball.getNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNumber());
    }
}
