package baseball.validation;

import baseball.resource.AskRestartValue;

public final class AskValidation {
    public void isCheckRestartInput(String userInput) {
        if (userInput.equals(AskRestartValue.RESTART_GAME)
                || userInput.equals(AskRestartValue.END_GAME)) {
            return;
        }

        throw new IllegalArgumentException();
    }
}
