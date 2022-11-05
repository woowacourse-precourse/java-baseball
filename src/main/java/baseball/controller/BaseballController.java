package baseball.controller;

import static baseball.controller.GameFlag.START;

public class BaseballController {
    private GameFlag gameFlag;

    public BaseballController() {
        this.gameFlag = START;
    }

    public void startGame() {
        while (gameFlag == START) {

        }
    }
}
