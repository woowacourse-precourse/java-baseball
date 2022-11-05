package baseball;

public enum GameProgressMessage {
    GAME_END_MESSAGE(
            "====Game Over... Please Enter If You want to====\n" +
                    "[restart : 1 | exit : 2]"
    ),
    GAME_PROGRESS_MESSAGE(
            "====Please Enter The Number You are Guessing!===="
    );

    private final String message;

    GameProgressMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
