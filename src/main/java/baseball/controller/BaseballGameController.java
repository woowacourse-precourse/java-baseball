package baseball.controller;

import baseball.domain.BaseballGameStatus;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {

    private final InputView inputView;
    private final OutputView outputView;

    private BaseballGameStatus gameStatus;

    public BaseballGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameStatus = BaseballGameStatus.PLAY;
    }

    public void run() {
        outputView.startBaseballGame();

        while (gameStatus.isGameContinues()) {
            inputView.inputBaseballNumber();

            gameStatus = inputView.inputGameStatus();
        }
    }
}
