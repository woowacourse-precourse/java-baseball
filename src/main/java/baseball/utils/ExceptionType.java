package baseball.utils;

public enum ExceptionType {

    NOT_NUMBER_OR_HAVE_ZERO("입력한 값 중 숫자가 아니거나 0이 포함되어 있습니다."),
    NOT_OVERLAP("입력한 값 중 중복된 값이 존재합니다."),
    INVALID_NUMBER_RANGE("입력한 값의 범위가 잘못되었습니다."),
    INVALID_NUMBER_END_OR_RESTART("종료 및 재시작 하기 위한 숫자와 일치하지 않습니다.");

    private final String message;

    ExceptionType(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
