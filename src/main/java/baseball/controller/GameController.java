package baseball.controller;

import baseball.model.AnswerNumber;
import baseball.model.GameResult;
import baseball.model.PlayerNumber;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {

    public static void run() {
        OutputView.printGameStart();
        String inputNum = InputView.requestNum();
        AnswerNumber answerNumber = new AnswerNumber();
        PlayerNumber playerNumber = new PlayerNumber(inputNum);
        GameResult gameResult = new GameResult(answerNumber.get(), playerNumber.get());
        OutputView.printGameResult(gameResult);
    }
}
