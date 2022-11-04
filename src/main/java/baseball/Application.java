package baseball;

import domain.Game;

public class Application {
    public static void main(String[] args) {
        Game game = new Game();
        Game.startGame();
    }
}
