package baseball;

import baseball.controller.Game;
import baseball.model.Player;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        do {
            Game game = new Game();
            game.playGame();
        }
        while (Player.continueGame());
    }
}
