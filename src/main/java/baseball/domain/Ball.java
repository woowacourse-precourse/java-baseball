package baseball.domain;

import java.util.Arrays;

public enum Ball {

    ONE(1),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9);

    private final int number;

    Ball(int number) {
        this.number = number;
    }

    public static Ball fromNumber(int number) {
        return Arrays.stream(Ball.values())
                .filter(ball -> ball.number == number)
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
