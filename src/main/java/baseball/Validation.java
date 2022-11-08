package baseball;

import baseball.resource.AskRestartGame;

public final class Validation {
    private String userInput;

    public void setUserInput(String userInput) {
        this.userInput = userInput;
    }

    public boolean isCheckRestartInput() {
        if (this.userInput.equals(AskRestartGame.RESTART_GAME)
                || this.userInput.equals(AskRestartGame.END_GAME)) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
