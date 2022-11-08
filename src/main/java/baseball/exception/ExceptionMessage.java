package baseball.exception;

public enum ExceptionMessage {
    NOT_FORMAT_CORRECT("숫자 야구 입력 형식이 올바르지 않습니다."),
    NOT_RESTART_FORMAT("입력한 값이 1 또는 2가 아닙니다."),
    NOT_INTEGER_FORMAT("입력한 값이 숫자가 아닙니다.");

    private String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return message;
    }
}
