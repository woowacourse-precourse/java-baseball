package baseball.controller;

import baseball.model.Balls;
import baseball.model.NumberGenerator;
import baseball.model.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseBallController {

    private static final int CONTINUE = 1;

    public void run() {
        OutputView.startMessage();
        playGames();
    }

    private void playGames() {
        int command = CONTINUE;

        while (isContinueGame(command)) {
            playGame();
            command = InputView.inputContinueGame();
        }
    }

    private static boolean isContinueGame(int command) {
        return command == CONTINUE;
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
