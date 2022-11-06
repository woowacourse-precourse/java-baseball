package baseball.controller;

import baseball.domain.CreateRandomNumber;
import baseball.domain.VerifyBaseballNumbers;
import baseball.exception.CheckContinueMessageException;
import baseball.view.InputNumView;
import baseball.view.OutputResultView;

public class GameController {
    public static void run() {
        runGame();
        checkContinue();
    }

    private static void runGame() {
        int strikeCount = 0;
        int ballCount = 0;

        CreateRandomNumber createRandomNumber = new CreateRandomNumber();
        while (strikeCount != 3) {
            VerifyBaseballNumbers verifyBaseballNumbers = new VerifyBaseballNumbers(InputNumView.inputBaseballNumber());
            ballCount = verifyBaseballNumbers.calculateBallCount(createRandomNumber.randomNumbers());
            strikeCount = verifyBaseballNumbers.calculateStrikeCount(createRandomNumber.randomNumbers());
            OutputResultView.printResult(ballCount, strikeCount);
        }
        OutputResultView.printWinMessage();
    }

    private static void checkContinue() {
        String continueMessage = InputNumView.askContinue();

        if (continueMessage.equals("1")) {
            runGame();
            return;
        }

        if (continueMessage.equals("2")) {
            OutputResultView.printEndMessage();
            return;
        }
        throw new CheckContinueMessageException();
    }
}
