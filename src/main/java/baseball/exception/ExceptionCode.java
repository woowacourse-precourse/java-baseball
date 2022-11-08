package baseball.exception;

public enum ExceptionCode{
    NUMBER_NOT_3_DIGITS("세 자리 수가 아닙니다."),
    NUMBER_NOT_IN_RANGE_FROM_1_TO_9("각 자리의 숫자는 1부터 9사이의 숫자여야합니다."),
    NUMBER_DUPLICATED("각 자리 숫자는 중복될 수 없습니다."),
    NOT_NUMBER("숫자가 아닙니다."),
    ONLY_1_OR_2_POSSIBLE("1 또는 2만 입력할 수 있습니다."),
    BALLS_AND_STRIKES_NOT_VALID("볼 스크라이크 개수가 유효하지 않습니다.");

    private String message;
    ExceptionCode(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
