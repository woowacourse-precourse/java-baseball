package baseball;

public enum GameProgressMessage {
    GAME_PROGRESS_ASK_QUIT(
            "====Game Over... Please Enter If You want to====\n" +
                    "[restart : 1 | exit : 2]"
    ),
    GAME_PROGRESS_MESSAGE(
            "====Please Enter The Number You are Guessing!===="
    ), GAME_PROGRESS_RESTART("재시작"),
    GAME_PROGRESS_END("게임 종료");

    private final String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
