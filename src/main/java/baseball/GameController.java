package baseball;

import java.util.Arrays;

import baseball.domain.BaseballGameCalculator;
import baseball.domain.BaseballNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final int[] STRIKE_3 = {0, 3};
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
        int[] result;

        do {
            outputView.printInputMessage();
            BaseballNumber user = BaseballNumber.createByUserInput(inputView.getUserBaseballNumber());
            result = BaseballGameCalculator.calculateBallStrikeCount(computer, user);
            outputView.printBSOResult(result);
        } while (!Arrays.equals(result, STRIKE_3));

        outputView.print3StrikeMessage();
    }
}
