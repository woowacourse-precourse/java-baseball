package baseball.exception;

public enum ExceptionMessage {
    NOT_FORMAT_CORRECT("숫자 야구 입력 형식이 올바르지 않습니다.");

    private String message;

    ExceptionMessage(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
