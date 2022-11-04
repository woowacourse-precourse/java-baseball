package baseball.domain;

import java.util.Arrays;

public enum Command {

    RESTART(1),
    EXIT(2);

    private final int commandNum;

    Command(final int commandNum) {
        this.commandNum = commandNum;
    }

    public static boolean hasValue(Integer num) {
        return Arrays.stream(Command.values())
                .anyMatch(x -> x.commandNum().equals(num));
    }

    public Integer commandNum() {
        return commandNum;
    }
}
