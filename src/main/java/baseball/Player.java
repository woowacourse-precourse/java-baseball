package baseball;

public class Player {
    private static final String WANT_RESTART="1";
    private static final String WANT_EXIT="2";

    private Baseballs input;

    public Player() {
    }

    public void initMyAnswerBy(String playerInput) {
        this.input = Baseballs.of(playerInput);
    }

    public boolean wantRestart(String playerInput) {
        validate(playerInput);
        return true;
    }

    private void validate(String playerInput) {
        if (playerInput.equals(WANT_EXIT) || playerInput.equals(WANT_RESTART)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
