package baseball.domain.Validation;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Restart {
    RESTART(1, true),
    END(2, false);

    private final int value;
    private final boolean restart;
    private static final Map<Integer, Boolean> VALUE_RESTART_MAP =
            Stream.of(values()).collect(Collectors.toMap(Restart::getValue, Restart::getRestart));

    Restart(int value, boolean restart) {
        this.value = value;
        this.restart = restart;
    }

    public static Boolean isRestart(int value) {
        return VALUE_RESTART_MAP.get(value);
    }

    public int getValue() {
        return value;
    }

    private boolean getRestart() {
        return restart;
    }
}
