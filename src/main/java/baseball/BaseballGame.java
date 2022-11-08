package baseball;

import baseball.resource.AskRestartValue;
import baseball.resource.GameMessage;
import baseball.validation.AskValidation;
import camp.nextstep.edu.missionutils.Console;

public class BaseballGame {
    User user;

    public BaseballGame() {
        this.user = new User();
    }

    public boolean askNewGame() {
        if (user.inputRestartNumber() && user.getRestartStatus()) {
            return true;
        }

        return false;
    }

    public void playGame() {
        User user = new User();

        while (user.inputBaseballNumber()) {
            System.out.println("test");
        }
    }
}
