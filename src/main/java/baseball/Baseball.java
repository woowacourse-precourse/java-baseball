package baseball;

import baseball.controller.GameController;

public class Baseball {
    private GameState gameState = GameState.START;
    private GameController gameController =  new GameController();

    public void playGame() {
        gameController.start();
        gameController.play();
        gameController.end();
    }
}
