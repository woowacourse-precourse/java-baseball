package baseball.service;

import baseball.domain.baseball.Baseballs;
import baseball.domain.game.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballService {
    public void run() {
        InputView inputView = new InputView();

        Baseballs computerBaseballs = Baseballs.random();
        playGame(inputView, computerBaseballs);
    }

    private void playGame(InputView inputView, Baseballs computerBaseballs) {
        OutputView.gameStartMessage();
        while (true) {
            OutputView.inputNumberMessage();
            Baseballs userBaseballs = Baseballs.valueOf(inputView.input());

            GameService gameService = new GameService();
            Result result = gameService.progress(computerBaseballs, userBaseballs);

            OutputView.print(result.toString());

            if (result.isFinish()) {
                OutputView.gameEndMessage();
                break;
            }
        }
    }
}
