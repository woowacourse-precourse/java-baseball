package baseball.model;

public enum ValidateNumber {
    NUMBER_LENGTH(3);

    private final int code;

    ValidateNumber(int code) {
        this.code = code;
    }

    public int getNumber() {
        return this.code;
    }
}
