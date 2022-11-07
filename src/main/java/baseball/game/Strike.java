package baseball.game;

import java.util.Arrays;

public enum Strike {

    ZERO(0),

    ONE(1),

    TWO(2),

    THREE(3);
    private final int value;

    Strike(int value) {
        this.value = value;
    }

    public static Strike from(int value) {
        return Arrays.stream(Strike.values())
                .filter(it -> it.value == value)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
