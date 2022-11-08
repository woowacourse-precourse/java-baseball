package baseball.controller;

import baseball.model.GameNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private static final String WRONG_ANSWER_INPUT_MESSAGE = "1 혹은 2만 입력 가능합니다.";
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void gameProcess() {
        outputView.printStartGame();
        computerController.startGame(gameNumber);
        repeatGuessingAnswer();
        askRestartGame();
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

    private void askRestartGame() {
        String answer = inputView.enterAnswerRestartGame();
        wantRestartGame(answer);
    }

    private boolean wantRestartGame(String answer) {
        if (answer.equals("1")) {
            return true;
        } else if (answer.equals("2")) {
            return false;
        }

        throw new IllegalArgumentException(WRONG_ANSWER_INPUT_MESSAGE);
    }
}
