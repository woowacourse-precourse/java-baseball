package baseball.controller;

import baseball.model.Balls;
import baseball.model.NumberGenerator;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    public void run() {
        OutputView.startMessage();

        Balls userBalls = new Balls(InputView.inputNumbers());
        Balls computerBalls = new Balls(NumberGenerator.generate());

        Result result = computerBalls.match(userBalls);
        OutputView.reportResult(result);
    }
}
