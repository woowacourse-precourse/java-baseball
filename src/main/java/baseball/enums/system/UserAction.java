package baseball.enums.system;

import java.util.Arrays;

public enum UserAction {

    STOP_PROGRAM("2"),
    PLAY_ONE_MORE_TIME("1");

    private final String value;

    UserAction(String value) {
        this.value = value;
    }

    private String getValue() {
        return value;
    }

    public static UserAction getEnumByValue(String value) {
        return Arrays.stream(values()).filter((UserAction action) -> action.getValue().equals(value)).findFirst().get();
    }
}
