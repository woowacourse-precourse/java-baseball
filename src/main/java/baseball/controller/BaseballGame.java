package baseball.controller;

import baseball.domain.Baseball;
import baseball.domain.Numbers;
import baseball.domain.Result;
import baseball.utils.BaseBallRandomNumbersGenerator;
import baseball.utils.BaseballNumbersGenerator;
import baseball.utils.Constants;
import baseball.utils.ErrorMessage;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class BaseballGame {

    private Baseball baseball;

    public Numbers requestUserNumbers() {
        try {
            List<Integer> inputNumbers = InputView.readUserNumbers();
            return new Numbers(inputNumbers);
        } catch (IllegalArgumentException e) {
            ErrorMessage.printError(e.getMessage());
            return requestUserNumbers();
        }
    }

    public void startGame() {
        OutputView.printStartMessage();
        BaseballNumbersGenerator numbersGenerator = new BaseBallRandomNumbersGenerator();
        this.baseball = new Baseball(numbersGenerator);
    }

    public void startRound() {
        do {
            Numbers userNumbers = requestUserNumbers();
            Result result = new Result(baseball, userNumbers);
            OutputView.printGameStatus(result);
            if (baseball.countStrike(userNumbers) == Constants.NUMBERS_SIZE) {
                OutputView.printResult();
            }
        } while (baseball.isGameContinue());
    }

    public int requestGameCommand() {
        try {
            return InputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            ErrorMessage.printError(e.getMessage());
            return requestGameCommand();
        }
    }

    public void quitGameOrNot() {
        if (requestGameCommand() == Constants.GAME_RESTART) {
            BaseballNumbersGenerator numbersGenerator = new BaseBallRandomNumbersGenerator();
            this.baseball = new Baseball(numbersGenerator);
        }
    }

    public boolean isGameContinue() {
        return baseball.isGameContinue();
    }
}