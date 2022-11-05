package baseball;

public enum Digits {
    FIRST(1), LAST(9), RANGE(3);

    private int digit;

    Digits(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }
}
