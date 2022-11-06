package baseball.domain;

import java.util.Arrays;

public enum Ball {
    ZERO(0),
    ONE(1),
    TWO(2),
    THREE(3);

    private final int value;

    Ball(int value) {
        this.value = value;
    }

    public static Ball from(int value) {
        return Arrays.stream(Ball.values())
                .filter(it -> it.value == value)
                .findFirst().orElseThrow(IllegalArgumentException::new);
    }
}
