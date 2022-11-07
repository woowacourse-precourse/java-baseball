package baseball.model;

import static baseball.error.ErrorMessage.CONTINUE_ERROR_MESSAGE;

public class ContinueGame {
    private ContinueGame() {
    }

    public static ContinueGame getInstance() {
        return new ContinueGame();
    }

    public boolean selectContinueGame(String inputToSelectContinueGame) {
        validateContinueInput(inputToSelectContinueGame);
        boolean continueGame = isContinueGame(inputToSelectContinueGame);
        return continueGame;
    }

    private void validateContinueInput(String inputToSelectContinueGame){
        String pattern = "[1-2]";
        if (!inputToSelectContinueGame.matches(pattern)) {
            throw new IllegalArgumentException(CONTINUE_ERROR_MESSAGE);
        }
    }

    private boolean isContinueGame(String inputToSelectContinueGame) {
        if (inputToSelectContinueGame.equals("2")) {
            return false;
        }
        return true;
    }
}
