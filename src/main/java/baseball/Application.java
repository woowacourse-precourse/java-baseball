package baseball;

import baseball.application.BaseballGame;
import baseball.application.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new BaseballGame();

        boolean isRunning = true;

        while (isRunning) {
            game.run();
            
            isRunning = game.selectContinueYn();
        }

        System.out.println("게임 종료");
    }
}
