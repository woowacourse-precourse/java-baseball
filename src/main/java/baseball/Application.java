package baseball;

import baseball.model.BaseballNumber;
import baseball.model.Game;
import baseball.model.PlayResult;
import baseball.view.InputView;
import baseball.view.ResultView;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();
        InputView inputView = new InputView();
        inputView.printStartGame();

        while (true) {
            Game game = new Game();
            boolean isEnd = false;
            while (!isEnd) {
                BaseballNumber baseballNumber = new BaseballNumber(inputView.inputUserNumber());
                PlayResult playResult = game.playGame(baseballNumber);
                resultView.printResult(playResult);
                isEnd = playResult.success();
            }
            resultView.printEndGame();
            if(Console.readLine().equals("2")) {
                break;
            }
        }
    }
}
