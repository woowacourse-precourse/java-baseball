package baseball.utils;

import static baseball.utils.ErrorMessage.INVALID_ARGUMENT;

public enum ProgressStatus {
    RESTART_FLAG(1),
    END_FLAG(2);

    private final int code;

    ProgressStatus(int code) {
        this.code = code;
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
