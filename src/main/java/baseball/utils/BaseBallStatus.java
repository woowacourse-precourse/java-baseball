package baseball.utils;

public enum BaseBallStatus {
    BASEBALL_DEFAULT_SIZE(3);

    private final int code;

    BaseBallStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
