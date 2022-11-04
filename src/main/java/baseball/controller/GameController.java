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
            boolean isGameOver = false;
            AnswerNumber answerNumber = new AnswerNumber();
            while (!isGameOver) {
                String inputNum = InputView.requestNum();
                PlayerNumber playerNumber = new PlayerNumber(inputNum);
                GameResult gameResult = new GameResult(answerNumber.get(), playerNumber.get());
                isGameOver = gameResult.isThreeStrike();
                OutputView.printGameResult(gameResult);
            }
            isReGame = InputView.requestIsReGame();
        }
    }
}
