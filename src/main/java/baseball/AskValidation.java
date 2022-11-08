package baseball;

import baseball.resource.AskRestartValue;

public final class AskValidation {
    public boolean isCheckRestartInput(String userInput) {
        if (userInput.equals(AskRestartValue.RESTART_GAME)
                || userInput.equals(AskRestartValue.END_GAME)) {
            return true;
        }

        throw new IllegalArgumentException();
    }
}
