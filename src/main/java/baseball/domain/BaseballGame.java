package baseball.domain;

import baseball.Input;
import baseball.Output;

public class BaseballGame {
    private static Computer computer;

    private BaseballGame() {
    }

    public static BaseballGame init() {
        BaseballGame game = new BaseballGame();
        game.computer = new Computer();
        return game;
    }

    public void start() {
        Input.startGameMessage();
        computer.makeAnswer();
        while (true) {
            Result result = checkResultOfEnteredValue();
            if (result.isThreeStrike()) {
                Output.showGameCompleteMessage();
                break;
            }
        }
        decideWhatToDoNext();
    }

    private Result checkResultOfEnteredValue() {
        BaseballNumber guessNumber = new BaseballNumber(Input.enterGuessNumber());
        Result result = computer.returnResult(guessNumber);
        Output.showGuessResult(result);
        return result;
    }

    private void decideWhatToDoNext() {
        Integer code = Input.askWhatToDo();
        if (code == 1) {
            start();
        }
        if (code == 2) {
            return;
        }
    }
}
