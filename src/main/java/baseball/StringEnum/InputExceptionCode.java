package baseball.StringEnum;

public enum InputExceptionCode {
    NOT_NUMBER_INCLUDE("숫자만 입력할 수 있습니다."),
    NOT_3_NUMBERS("1 부터 9 사이의 3개의 숫자만 입력할 수 있습니다."),
    NOT_IN_RANGE("1 부터 9 사이의 3개의 숫자만 입력할 수 있습니다."),
    DUPLICATE_NUMBER("서로 다른 3개의 숫자만 입력할 수 있습니다."),
    NOT_RESTART_NUMBER("새로 시작 (1), 종료 (2) 중 하나 만을 입력 할 수 있습니다.");

    private final String code;

    InputExceptionCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
