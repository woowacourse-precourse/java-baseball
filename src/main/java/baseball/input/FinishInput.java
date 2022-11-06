package baseball.input;

public enum FinishInput {
    RESTART_GAME(1),
    QUIT_GAME(2);

    private final int input;

    FinishInput(int input) {
        this.input = input;
    }

    public static FinishInput numberOf(int input) {
        switch (input) {
            case 1:
                return FinishInput.RESTART_GAME;
            case 2:
                return FinishInput.QUIT_GAME;
            default:
                throw new IllegalArgumentException("1또는 2를 입력해주세요.");
        }
    }
}
