package baseball.domain;

import java.util.Arrays;

public enum Digit {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);
    private final int value;

    Digit(int value) {
        this.value = value;
    }

    public static Digit from(int value) {
        return Arrays.stream(Digit.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
