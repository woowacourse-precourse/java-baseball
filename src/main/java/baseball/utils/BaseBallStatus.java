package baseball.utils;

public enum BaseBallStatus {
    ANSWER_DEFAULT_SIZE(3),
    MIN_BASEBALL_NUMBER(1),
    MAX_BASEBALL_NUMBER(9);

    private final int code;

    BaseBallStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static boolean isOutOfRange(int number) {
        return (number < MIN_BASEBALL_NUMBER.code) || (number > MAX_BASEBALL_NUMBER.code);
    }
}
