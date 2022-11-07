package baseball.domain;

import java.util.Arrays;

public enum CommandKey {
    RETRY(1),
    FINISH(2);

    private final int value;

    CommandKey(int value) {
        this.value = value;
    }

    public static CommandKey from(int value) {
        return Arrays.stream(CommandKey.values())
                .filter(it -> it.value == value)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
