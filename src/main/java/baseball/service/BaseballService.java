package baseball.service;

import baseball.domain.baseball.Baseballs;
import baseball.domain.game.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballService {
    public void run(boolean isFirstStart) {
        OutputView.gameStartMessage();
        run();
    }
    public void run() {
        Baseballs computerBaseballs = Baseballs.random();

        playGame(computerBaseballs);
        OutputView.gameEndMessage();
        OutputView.endOrRestartMessage();

        int isRestart = InputView.endOrRestartInput();
        if (isRestart == InputView.END) {
            return;
        }

        run();
    }

    private void playGame(Baseballs computerBaseballs) {
        while (true) {
            OutputView.inputNumberMessage();
            String input = InputView.userBaseballInput();
            Baseballs userBaseballs = Baseballs.valueOf(input);

            GameService gameService = new GameService();
            Result result = gameService.progress(computerBaseballs, userBaseballs);

            OutputView.print(result.toString());

            if (result.isFinish()) {
                break;
            }
        }
    }
}
