package baseball;

import baseball.domain.Game;

public class Application {
    public static void main(String[] args) {
        boolean playerWantNewGame = true;
        Game game = new Game();

        while (playerWantNewGame) {
            game.run();
            playerWantNewGame = game.dosePlayerWantNewGame();
        }
    }
}
