package baseball.util.input;

import baseball.util.GameExceptionMessage;

public class ContinueInput implements UserInput {
    private final String continueInput;
    private final int CONTINUE_GAME = '1';
    private final int EXIT_GAME = '2';

    public ContinueInput() {
        continueInput = get();
    }

    @Override
    public void validate(String input) {
        if (input.length() > 1 || !continueOrExit(input)) {
            throw new IllegalArgumentException(GameExceptionMessage.CONTINUE_OR_EXIT);
        }
    }

    private boolean continueOrExit(String input) {
        return continueGame(input) || exitGame(input);
    }

    private boolean exitGame(String input) {
        return input.charAt(0) == EXIT_GAME;
    }

    private boolean continueGame(String input) {
        return input.charAt(0) == CONTINUE_GAME;
    }
    public boolean continueGame() {
        return continueGame(continueInput);
    }
}
