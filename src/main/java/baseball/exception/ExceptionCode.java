package baseball.exception;

public enum ExceptionCode {
    RANDOM_NUMBER_NOT_VALID("생성된 랜덤넘버가 유효하지 않습니다."),
    INPUT_NOT_VALID("입력한 값이 유효하지 않습니다.");

    private String message;

    ExceptionCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
