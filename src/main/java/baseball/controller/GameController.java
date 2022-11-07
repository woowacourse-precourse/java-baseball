package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void gameProcess() {
        outputView.printStartGame();
        computerController.startGame(gameNumber);
        repeatGuessingAnswer();
    }

    private void repeatGuessingAnswer() {
        boolean correctAnswer = false;
        while (!correctAnswer) {
            String inputString = inputView.enterGameNumber();
            gameNumber.setInputString(inputString);
            computerController.compareNumbers(gameNumber);
            computerController.provideHint();

            correctAnswer = computerController.isThreeStrike();
            if (correctAnswer) {
                outputView.printEndGame();
            }
        }
    }
}
