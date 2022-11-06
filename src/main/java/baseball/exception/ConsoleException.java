package baseball.exception;

public enum ConsoleException {
    BASEBALL_INPUT_EXCEPTION("조건에 맞지 않는 숫자입니다.");

    private final String message;

    ConsoleException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
