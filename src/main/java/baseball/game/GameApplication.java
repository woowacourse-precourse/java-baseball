package baseball.game;

import baseball.input.validation.UserNumberValidation;
import baseball.input.view.InputView;

public class GameApplication {

    public static void startGame() {
        String userNumber = InputView.inputNumber();

        if (!UserNumberValidation.isValidNumberLength(userNumber)) {
            throw new IllegalArgumentException();
        }
    }

}
