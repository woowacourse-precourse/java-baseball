package baseball.controller;

import baseball.model.Balls;
import baseball.model.NumberGenerator;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    public void run() {
        OutputView.startMessage();
        playGame();
    }

    private void playGame() {
        boolean isGameEnd = false;
        Balls computerBalls = new Balls(NumberGenerator.generate());

        while (!isGameEnd) {
            Result result = matchBalls(computerBalls);
            OutputView.reportResult(result);
            isGameEnd = result.isGameEnd();
        }
        OutputView.endMessage();
    }

    private Result matchBalls(Balls computerBalls) {
        return computerBalls.match(new Balls(InputView.inputNumbers()));
    }
}
