package baseball.util.input;

import baseball.util.GameExceptionMessage;

public class GameEndInput {
    private final int gameEndInput;
    private final int CONTINUE_GAME = 1;
    private final int EXIT_GAME = 2;
    private final int INPUT_LENGTH = 1;

    public GameEndInput(String gameEndInput) {
        validate(gameEndInput);
        this.gameEndInput = Integer.parseInt(gameEndInput);
    }

    public void validate(String gameEndInput) {
        if (supportsInputLength(gameEndInput) &&
                hasNumber(gameEndInput) &&
                continueOrExit(Integer.parseInt(gameEndInput))
        ) {
            return;
        }
        throw new IllegalArgumentException(GameExceptionMessage.ENTER_CONTINUE_NUMBER_OR_EXIT_NUMBER);
    }

    private boolean hasNumber(String gameEndInput) {
        try {
            Integer.parseInt(gameEndInput);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private boolean supportsInputLength(String gameEndInput) {
        return !gameEndInput.isBlank() && gameEndInput.length() == INPUT_LENGTH;
    }

    private boolean continueOrExit(int gameEndInput) {
        return continueGame(gameEndInput) || exitGame(gameEndInput);
    }

    private boolean exitGame(int gameEndInput) {
        return gameEndInput == EXIT_GAME;
    }

    private boolean continueGame(int gameEndInput) {
        return gameEndInput == CONTINUE_GAME;
    }

    public boolean continueGame() {
        return continueGame(gameEndInput);
    }
}
