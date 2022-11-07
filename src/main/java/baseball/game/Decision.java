package baseball.game;

import java.util.Arrays;

public enum Decision {
    RE_GAME("1"),
    END("2");

    private final String decision;

    Decision(String decision) {
        this.decision = decision;
    }

    public static Decision from(String input) {
        return Arrays.stream(values())
                .filter(decision -> decision.match(input))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean match(String input) {
        return decision.equals(input);
    }
}
