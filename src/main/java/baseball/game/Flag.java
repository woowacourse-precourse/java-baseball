package baseball.game;

import java.util.Arrays;
import java.util.Objects;

public enum Flag {
    CONTINUE("1", true),
    EXIT("2", false);

    private final String number;
    private final boolean again;

    Flag(String number, boolean again) {
        this.number = number;
        this.again = again;
    }

    public static Flag findByNumber(String number) {
        return Arrays.stream(Flag.values())
                .filter(flag -> flag.equalsNumber(number))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean equalsNumber(String findNumber) {
        return Objects.equals(this.number, findNumber);
    }
    public boolean isAgain() {
        return again;
    }
}
