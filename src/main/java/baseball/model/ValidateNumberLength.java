package baseball.model;

public enum ValidateNumberLength {
    NUMBER_LENGTH(3);

    private final int code;

    ValidateNumberLength(int code) {
        this.code = code;
    }

    public int getNumber() {
        return this.code;
    }
}
