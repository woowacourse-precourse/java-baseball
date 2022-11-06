package baseball;

import baseball.controller.GameController;

public class Baseball {
    private GameState gameState = GameState.START;
    private GameController gameController =  new GameController();

    public void playGame() {
        do {
            gameController.start();
            gameController.play();
            gameController.end();
        } while (gameController.replay());
    }
}
