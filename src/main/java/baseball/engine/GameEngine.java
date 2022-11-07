package baseball.engine;

import baseball.Game;

import static baseball.constant.BaseballConstant.GAME_START;

public class GameEngine {

    public void start() {
        printGameStart();

        Game game = new Game();
        int restart;

        do {
            restart = game.play();
        } while (restart != 2);
    }

    private void printGameStart() {
        System.out.println(GAME_START);
    }
}
