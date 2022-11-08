package baseball.domain.game;

public enum Digits {
    ZERO(0), FIRST(1), LAST(9), SIZE(3);

    private final int digit;

    Digits(int digit) {
        this.digit = digit;
    }

    public int getDigit() {
        return digit;
    }
}
