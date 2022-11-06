package baseball;

import baseball.game.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        while (!game.isEnd()) {
            game.start();
            game.play();
            game.pause();
        }
    }
}
