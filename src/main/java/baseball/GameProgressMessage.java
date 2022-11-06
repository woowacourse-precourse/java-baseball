package baseball;

public enum GameProgressMessage {
    ASK_QUIT(
            "====Game Over... Please Enter If You want to====\n" +
                    "[restart : 1 | exit : 2]"
    ),
    PROGRESS_MESSAGE(
            "====Please Enter The Number You are Guessing!===="
    ),
    RESTART("재시작"),
    END("게임 종료");

    private final String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
