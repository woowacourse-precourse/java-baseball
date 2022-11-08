package baseball;

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
                BaseballNumber baseballNumber = new BaseballNumber(Console.readLine());
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
