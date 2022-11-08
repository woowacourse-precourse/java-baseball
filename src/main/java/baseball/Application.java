package baseball;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            while (true) {
                Game game = new Game();
                boolean isEnd = false;
                while (!isEnd) {
                    PlayResult playResult = game.playGame(Console.readLine().split(""));
                    isEnd = playResult.success();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
