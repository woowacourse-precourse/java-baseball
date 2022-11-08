package baseball.number.util;

public enum GameNumberRange {

    BALL_SIZE(3),
    NUMBER_LENGTH(3),
    RANGE_MIN(1),
    RANGE_MAX(9);

    private int number;

    private GameNumberRange(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
