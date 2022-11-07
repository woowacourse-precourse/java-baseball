package baseball.game;

import java.util.Arrays;

public enum Decision {
    RE_GAME("1"),
    END("2");

    private final String signal;

    Decision(String signal) {
        this.signal = signal;
    }

    public static Decision from(String input) {
        return Arrays.stream(values())
                .filter(signal -> signal.match(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean match(String input) {
        return signal.equals(input);
    }
}
