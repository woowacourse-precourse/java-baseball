package baseball.game.input;

public enum FinishInput {
    RESTART_GAME,
    QUIT_GAME;

    public static final String RESTART_GAME_INPUT = "1";
    public static final String QUIT_GAME_INPUT = "2";

    public static FinishInput numberOf(String input) {
        switch (input) {
            case RESTART_GAME_INPUT:
                return FinishInput.RESTART_GAME;
            case QUIT_GAME_INPUT:
                return FinishInput.QUIT_GAME;
            default:
                throw new IllegalArgumentException("1또는 2를 입력해주세요.");
        }
    }
}
