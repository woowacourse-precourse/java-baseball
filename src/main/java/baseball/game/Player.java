package baseball.game;

import baseball.baseballs.Baseballs;

public class Player {
    private static final String WANT_RESTART = "1";
    private static final String WANT_EXIT = "2";
    private static final boolean YES = true;
    private static final boolean NO = false;

    private Baseballs input;

    public Player() {
    }

    public void initMyAnswerBy(String playerInput) {
        this.input = Baseballs.of(playerInput);
    }

    public Baseballs submitAnswer() {
        return this.input;
    }

    public boolean wantRestart(String playerInput) {
        validate(playerInput);
        if (playerInput.equals(WANT_RESTART)) {
            return YES;
        }
        return NO;
    }

    private void validate(String playerInput) {
        if (playerInput.equals(WANT_EXIT) || playerInput.equals(WANT_RESTART)) {
            return;
        }
        throw new IllegalArgumentException();
    }
}
