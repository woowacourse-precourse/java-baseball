package baseball.input;

public enum FinishInput {
    RESTART_GAME(1),
    QUIT_GAME(2);

    private final int input;

    FinishInput(int input) {
        this.input = input;
    }
}
