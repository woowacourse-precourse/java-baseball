package baseball;

import baseball.game.GameService;

public class Application {
    public static void main(String[] args) {
        boolean gameOn = true;

        while (gameOn) {
            GameService game = new GameService();

            game.start();
            game.over();
            gameOn = game.restart();
        }
    }
}
