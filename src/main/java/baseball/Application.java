package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ResultView resultView = new ResultView();

        while (true) {
            Game game = new Game();
            boolean isEnd = false;
            while (!isEnd) {
                PlayResult playResult = game.playGame(Console.readLine().split(""));
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
