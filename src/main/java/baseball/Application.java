package baseball;

import baseball.game.BaseballGame;
import baseball.game.Game;

public class Application {

    public static void main(String[] args) {
        startGame(new BaseballGame());
    }

    private static void startGame(final Game game) {
        game.showStartMessage();
        do {
            game.start();
            game.showEndMessage();
        } while (game.isRestart());
    }
}
