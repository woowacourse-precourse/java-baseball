package baseball.util.input;

import baseball.util.GameExceptionMessage;

public class GameEndInput {
    private final int gameEndInput;
    private final int CONTINUE_GAME = 1;
    private final int EXIT_GAME = 2;

    public GameEndInput(String gameEndInput) {
        validate(gameEndInput);
        this.gameEndInput = Integer.parseInt(gameEndInput);
    }

    public void validate(String continueInput) {
        if (continueInput.length() > 1) {
            throw new IllegalArgumentException(GameExceptionMessage.CONTINUE_OR_EXIT);
        }
        try {
            if (!continueOrExit(Integer.parseInt(continueInput))) {
                throw new IllegalArgumentException(GameExceptionMessage.CONTINUE_OR_EXIT);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(GameExceptionMessage.CONTINUE_OR_EXIT);
        }
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
