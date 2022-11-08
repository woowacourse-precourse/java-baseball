package baseball.domain;

public class Ball {
    private final Number number;
    private final Position position;

    private Ball(Number number, Position position) {
        this.number = number;
        this.position = position;
    }

    public static Ball of(Number number, Position position) {
        return new Ball(number, position);
    }

    public int number() {
        return number.value();
    }

    public int position() {
        return position.value();
    }
}
