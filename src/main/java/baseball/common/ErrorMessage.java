package baseball.common;

public enum ErrorMessage {
    EXCEPTION_NOT_INPUT3("입력한 수의 갯수가 옳지 않습니다."),
    EXCEPTION_SAME_INPUT("중복된 수가 존재합니다."),
    EXCEPTION_NOT_SCOPE_INPUT("수의 범위가 알맞지 않습니다."),
    EXCEPTION_NOT_RESTART_INPUT("1 혹은 2를 입력해야합니다.");

    private final String value;

    ErrorMessage(String value) {
        this.value = value;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
