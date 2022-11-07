package baseball.status;

public enum Constants {

    NUMBER_OF_DIGITS(3),
    MIN_RANGE_OF_DIGITS(1),
    MAX_RANGE_OF_DIGITS(9),
    FIRST_CHARACTER_OF_DIGITS('0'),

    ZERO_COUNT(0),
    COUNT(1),

    GAME_CONTINUE(1),
    GAME_STOP(2);

    private final int number;

    Constants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
