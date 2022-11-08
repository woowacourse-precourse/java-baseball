package baseball;

import baseball.domain.BaseballGameResult;

import baseball.domain.BaseballGameCalculator;
import baseball.domain.BaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final String GAME_RESTART_CODE = "1";
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        do {
            startGame();
            outputView.printRestartMessage();
        } while (inputView.askRestart().equals(GAME_RESTART_CODE));
    }

    private void startGame() {
        outputView.printGameStartMessage();
        BaseballNumber computer = BaseballNumber.createByRandom();
        BaseballNumber user;
        BaseballGameResult result;

        do {
            outputView.printInputMessage();
            user = BaseballNumber.createByUserInput(inputView.getUserBaseballNumber());
            result = BaseballGameCalculator.calculateBallStrikeCount(computer, user);
            outputView.printBaseballGameResult(result);
        } while (!result.is3Strike());

        outputView.print3StrikeMessage();
    }
}
