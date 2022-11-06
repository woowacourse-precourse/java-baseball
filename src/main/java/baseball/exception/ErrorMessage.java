package baseball.exception;

public enum ErrorMessage {
    DUPLICATE_NUMBER("입력한 숫자 중에 중복된 숫자가 있습니다. 프로그램을 종료합니다."),
    NUMBER_SIZE("입력한 숫자의 개수가 올바르지 않습니다. 프로그램을 종료합니다."),
    RUN_CODE("입력한 숫자가 1 또는 2가 아닙니다. 프로그램을 종료합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return message;
    }
}