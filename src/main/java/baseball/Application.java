package baseball;

import baseball.game.Game;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException {
        Game game = new Game();
        game.start();
    }
}
