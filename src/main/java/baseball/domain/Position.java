package baseball.domain;

public class Position {
    public static final int MIN_POSITION = 1;
    public static final int MAX_POSITION = 3;

    private final int position;

    private Position(int position) {
        this.position = position;
    }

    public static Position from(int value) {
        validate(value);
        return new Position(value);
    }

    private static void validate(int value) {
        if (value < MIN_POSITION || value > MAX_POSITION) {
            throw new IllegalArgumentException("Position must be between " + MIN_POSITION + " and " + MAX_POSITION);
        }
    }

    public int value() {
        return this.position;
    }
}
