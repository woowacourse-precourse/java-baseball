package baseball.message;

public enum GameProgressMessage {
    ASK_QUIT(
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."
    ),
    PROGRESS_MESSAGE(
            "숫자를 입력해주세요 : "
    ),
    RESTART("재시작"),
    CLEAR_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    END("게임을 종료합니다.");

    private final String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
