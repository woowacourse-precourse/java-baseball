package baseball.status;

public enum Constants {

    NUMBER_OF_DIGITS(3),
    MIN_RANGE_OF_DIGITS(1),
    MAX_RANGE_OF_DIGITS(9);

    private final int number;

    Constants(final int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
