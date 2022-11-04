package baseball.model;

import java.util.Objects;

public class Ball {
    private final int number;
    private final int position;
    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public boolean isStrike(Ball other) {
        return this.number == other.number && this.position == other.position;
    }

    public boolean isBall(Ball other) {
        return this.number == other.number && this.position != other.position;
    }
}
