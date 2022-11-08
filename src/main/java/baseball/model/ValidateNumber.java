package baseball.model;

public enum ValidateNumber {
    FIRST_NUMBER(1),
    LAST_NUMBER(9),
    NUMBER_LENGTH(3);

    private final int number;

    ValidateNumber(int number) {
        this.number = number;
    }

    public int getNumber() {
        return this.number;
    }
}
