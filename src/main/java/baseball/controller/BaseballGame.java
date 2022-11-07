package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.Result;
import baseball.view.Command;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGame implements Game {
    @Override
    public void run() {
        Balls computerBalls = Balls.create();
        boolean isCorrect = false;

        while (!isCorrect) {
            Balls playerBalls = Balls.from(InputView.scanPlayerBalls());
            Result result = Result.getResult(computerBalls, playerBalls);
            OutputView.printResult(result);
            isCorrect = result.isCorrect();
        }
    }

    @Override
    public boolean replay() {
        Command command = Command.of(InputView.scanCommand());
        return command.isReplay();
    }
}
