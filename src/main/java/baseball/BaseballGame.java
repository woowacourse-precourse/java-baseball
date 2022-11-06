package baseball;

import java.util.List;

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
        computer.putAnswer();
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
        try {
            BaseballNumber guessNumber = new BaseballNumber(Input.enterGuessNumber());
            Result result = computer.returnResult(guessNumber);
            Output.showGuessResult(result);
            return result;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return checkResultOfEnteredValue();
    }

    private void decideWhatToDoNext() {
        try {
            Integer code = Input.askWhatToDo();
            if (code == 1) {
                start();
            }
            if (code == 2) {
                return;
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            decideWhatToDoNext();
        }
    }
}
