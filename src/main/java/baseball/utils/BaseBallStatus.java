package baseball.utils;

import static baseball.utils.ErrorMessage.INVALID_ARGUMENT;

public enum BaseBallStatus {
    BASEBALL_DEFAULT_SIZE(3),
    RESTART_FLAG(1),
    END_FLAG(2);

    private final int code;

    BaseBallStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    public static boolean isRestart(int code) {
        if (RESTART_FLAG.code == code) {
            return true;
        }
        if (END_FLAG.code == code) {
            return false;
        }
        throw new IllegalArgumentException(INVALID_ARGUMENT.getMessage());
    }
}
