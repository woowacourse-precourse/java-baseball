package baseball.util;

public enum GameCode {

    VALID_NUMBER_LENGTH(3),
    STRIKE_COUNT_FOR_END(3),
    RESTART_GAME(1),
    END_GAME(2);

    public final int code;

    public int getCode() {
        return this.code;
    }

    GameCode(int code) {
        this.code = code;
    }
}
