package baseball.controller;

import baseball.validator.PlayerInputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    public void play() {
        boolean gameFlag = true;

        while (gameFlag) {
            OutputView.startGameMessage();
            startGame();
            gameFlag = restartOrEnd();
        }
    }

    public void startGame() {

    }

    public boolean restartOrEnd() {
        String playerInput = InputView.restartOrEndMessage();

        PlayerInputValidator.restartOrEndValidate(playerInput);
        if (playerInput.equals("1")) {
            return true;
        }
        else {
            return false;
        }
    }
}
