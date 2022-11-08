package baseball.model;

public enum Range {
    MAX_COUNT(3), MIN_VALUE(1), MAX_VALUE(9);

    private final int value;
    Range(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
