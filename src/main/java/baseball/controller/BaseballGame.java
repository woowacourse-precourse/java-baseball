package baseball.controller;

import baseball.model.hint.Hint;
import baseball.model.number.BaseballNumbers;
import baseball.model.player.Computer;
import baseball.view.BaseballGameView;

public class BaseballGame {
    private final BaseballGameView gameView;
    private final Computer computer;

    BaseballGame() {
        gameView = new BaseballGameView();
        computer = new Computer();
    }

    private void init() {
        gameView.startBaseballGame();
        while(true) {
            BaseballNumbers userBaseballNumbers = getUserInput();
            Hint userHint = makeHint(userBaseballNumbers);
            checkUserInputCorrect(userHint);
        }
    }

    private BaseballNumbers getUserInput() {
        String userInput = gameView.getUserInput();
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userInput);
        return userBaseballNumbers;
    }

    private Hint makeHint(BaseballNumbers userBaseballNumbers) {
        Hint userInputHint = computer.makeUserInputHint(userBaseballNumbers);
        String userInputResult = userInputHint.getResult();
        gameView.printUserInputHint(userInputResult);
        return userInputHint;
    }

    private void checkUserInputCorrect(Hint userInputHint) {
        boolean isCorrect = userInputHint.isCorrectNumber();
        if(isCorrect) {
            gameView.endBaseballGame();
        }
    }
}
