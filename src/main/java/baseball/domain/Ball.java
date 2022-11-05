package baseball.domain;

public class Ball {
    private final int number;
    private final int position;

    private Ball(int number, int position) {
        this.number = number;
        this.position = position;
    }

    public static Ball of(int number, int position) {
        return new Ball(number, position);
    }

    public int getNumber() {
        return number;
    }

    public int getPosition() {
        return position;
    }
}
