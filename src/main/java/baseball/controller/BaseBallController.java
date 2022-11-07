package baseball.controller;

import baseball.model.Balls;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    public void run() {
        OutputView.startMessage();
        Balls userBalls = new Balls(InputView.inputNumbers());
    }
}
