package baseball.system.enums;

import java.util.Arrays;

public enum UserAction {

    STOP_PROGRAM(2),
    PLAY_ONE_MORE_TIME(1);

    private final Integer value;

    UserAction(Integer value) {
        this.value = value;
    }

    private Integer getValue() {
        return value;
    }

    public static UserAction getEnumByValue(Integer value) {
        return Arrays.stream(values()).filter((UserAction action) -> action.getValue() == value).findFirst().get();
    }
}
