package baseball.exception;

public enum ConsoleException {
    BASEBALL_INPUT_EXCEPTION("조건에 맞지 않는 숫자입니다."),
    ANOTHER_GAME_INPUT_EXCEPTION("존재하지 않는 게임 선택입니다.");

    private final String message;

    ConsoleException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
