package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.GameResult;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    public static void run() {
        boolean isReGame = true;

        OutputView.printGameStart();
        while (isReGame) {
            isReGame = playGame();
        }
    }

    public static boolean playGame() {
        boolean isGameOver = false;
        AnswerNumber answerNumber = new AnswerNumber();

        while (!isGameOver) {
            PlayerNumber playerNumber = new PlayerNumber(InputView.requestNum());
            GameResult gameResult = new GameResult(answerNumber.get(), playerNumber.get());

            isGameOver = gameResult.isThreeStrike();
        }
        return InputView.requestIsReGame();
    }
}
