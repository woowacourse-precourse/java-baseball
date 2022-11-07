package baseball.controller;

import static baseball.model.Constant.END_CODE_END;
import static baseball.model.Constant.END_CODE_RESTART;

import baseball.model.hint.Hint;
import baseball.model.number.BaseballNumbers;
import baseball.model.player.Computer;
import baseball.view.BaseballGameView;

public class BaseballGame {
    private final BaseballGameView gameView;
    private final Computer computer;
    private boolean isEnd = false;

    public BaseballGame() {
        gameView = new BaseballGameView();
        computer = new Computer();
    }

    public void startBaseballGame() {
        computer.createRandomNumbers();
        gameView.startBaseballGame();
        while(!isEnd) {
            BaseballNumbers userBaseballNumbers = getUserInput();
            Hint userHint = makeHint(userBaseballNumbers);
            boolean isCorrectAnswer = checkUserInputCorrect(userHint);
            if(isCorrectAnswer){
                readyToEndGame();
            }
        }
    }

    private BaseballNumbers getUserInput() {
        String userInput = gameView.getUserInput();
        BaseballNumbers userBaseballNumbers = new BaseballNumbers(userInput);
        return userBaseballNumbers;
    }

    private Hint makeHint(BaseballNumbers userBaseballNumbers) {
        Hint userInputHint = computer.makeUserInputHint(userBaseballNumbers);
        String userInputResult = userInputHint.getBaseballNumberCount();
        gameView.printUserInputHint(userInputResult);
        return userInputHint;
    }

    private boolean checkUserInputCorrect(Hint userInputHint) {
        boolean isCorrect = userInputHint.isCorrectNumber();
        return isCorrect;
    }

    private void readyToEndGame() {
        int endCode = gameView.endBaseballGame();
        if(endCode == END_CODE_RESTART) {
            computer.createRandomNumbers();
        }
        if(endCode == END_CODE_END) {
            this.isEnd = true;
        }
    }
}
