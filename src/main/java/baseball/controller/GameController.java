package baseball.controller;

import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    public static void run() {
        OutputView.printGameStart();
        String inputNum = InputView.requestNum();
        PlayerNumber playerNumber = new PlayerNumber(inputNum);
    }
}
