package baseball.controller;

import baseball.model.BallStrikeResult;
import baseball.model.GameNumber;
import baseball.model.OutputStrings;
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
            outputView.println(OutputStrings.START_GAME_ALERT);
            oppositeNumber = GameNumber.makeRandomInstance();
            repeatGetInputAndCompare();

            restartInput = getAndProcessRestartInput();
        } while(restartInput.shouldGameRestart());
    }

    private void repeatGetInputAndCompare() {
        BallStrikeResult result;
        do {
            GameNumber inputNumber = getAndProcessGameNumberInput();
            result = inputNumber.countBallStrike(oppositeNumber);
            outputView.println(result.toString());
        } while(!result.doesWin());
        outputView.println(OutputStrings.GAME_END_ALERT);
    }

    private GameNumber getAndProcessGameNumberInput() {
        outputView.print(OutputStrings.PUT_INPUT_ALERT);
        String inputString = inputView.readInput();

        return GameNumber.makeInstance(inputString);
    }

    private RestartMode getAndProcessRestartInput() {
        outputView.println(OutputStrings.AFTER_GAME_END_ALERT);
        String inputString = inputView.readInput();

        return RestartMode.makeInstance(inputString);
    }
}
