package baseball.exception;

public enum BaseballException {
    BASEBALL_SIZE_EXCEPTION("야구공 개수가 올바르지 않습니다.");

    private final String message;

    BaseballException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
