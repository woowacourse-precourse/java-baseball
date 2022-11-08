package baseball.controller;

import baseball.model.BallStrikeResult;
import baseball.model.GameNumber;

import baseball.model.RestartMode;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    private GameNumber oppositeNumber;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void runGame() {
        RestartMode restartInput;
        do {
            outputView.printStartGameAlert();
            oppositeNumber = GameNumber.getRandomInstance();

            repeatGetInputAndCompare();
            restartInput = getAndProcessRestartInput();
        } while(restartInput.shouldGameRestart());
    }

    private void repeatGetInputAndCompare() {
        BallStrikeResult result;
        do {
            GameNumber inputNumber = getAndProcessGameNumberInput();
            result = inputNumber.countBallStrike(oppositeNumber);
            outputView.printBallStrikeResult(result);
        } while(!result.doesWin());
        outputView.printGameEndAlert();
    }

    private GameNumber getAndProcessGameNumberInput() {
        outputView.printInputNumberAlert();
        String inputString = inputView.readInput();

        return GameNumber.getInstance(inputString);
    }

    private RestartMode getAndProcessRestartInput() {
        outputView.printAfterGameEndAlert();
        String inputString = inputView.readInput();
        return RestartMode.makeInstance(inputString);
    }
}
