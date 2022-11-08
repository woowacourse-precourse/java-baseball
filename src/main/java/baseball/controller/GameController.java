package baseball.controller;

import baseball.domain.Game;
import java.util.List;

public class GameController {
    private Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public void start() {
        game.startRound();
        while (game.isRunning()) {
            List<Integer> userInput = game.getUserInput();
            game.judgeUserInput(userInput);
        }
        boolean restart = game.decideRestart();
        if (restart) {
            initForRestart();
        }
    }

    private void initForRestart() {
        this.game = new Game();
        start();
    }
}
