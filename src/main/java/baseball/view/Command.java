package baseball.view;

public enum Command {
    QUIT("1"),
    REPLAY("2"),
    ;

    private final String value;

    Command(String value) {
        this.value = value;
    }

    public static Command of(String value) {
        if (QUIT.value.equals(value)) {
            return QUIT;
        }
        if (REPLAY.value.equals(value)) {
            return REPLAY;
        }
        throw new IllegalArgumentException("잘못된 입력입니다.");
    }

    public String getValue() {
        return value;
    }
}
