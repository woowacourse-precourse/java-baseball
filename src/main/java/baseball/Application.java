package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ResultView resultView = new ResultView();
        try {
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
