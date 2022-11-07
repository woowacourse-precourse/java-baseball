package baseball.exception;

public enum GameException {
    GAME_STATUS_NULL_EXCEPTION("존재하지 않는 게임 타입입니다.");

    private final String message;

    GameException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
