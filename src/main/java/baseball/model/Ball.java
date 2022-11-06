package baseball.model;

public class Ball {
    public static final int NUMBER_LOWER_BOUNDS = 1;
    public static final int NUMBER_UPPER_BOUNDS = 9;
    private final int number;
    private final int position;
    public Ball(int number, int position) {
        this.number = number;
        this.position = position;
        validateNumber();
    }

    private void validateNumber() {
        if (number < NUMBER_LOWER_BOUNDS || number > NUMBER_UPPER_BOUNDS) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isStrike(Ball other) {
        return this.number == other.number && this.position == other.position;
    }

    public boolean isBall(Ball other) {
        return this.number == other.number && this.position != other.position;
    }

    public int getNumber() {
        return number;
    }
}
