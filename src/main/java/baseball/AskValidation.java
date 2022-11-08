package baseball;

import baseball.resource.AskRestartGame;

public final class AskValidation {
    public boolean isCheckRestartInput(String userInput) {
        if (userInput.equals(AskRestartGame.RESTART_GAME)
                || userInput.equals(AskRestartGame.END_GAME)) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
