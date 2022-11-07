package baseball;

import baseball.view.SystemMessage;

public class Controller {
    final int SIZE = 3;
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;

    GameService gameService = new GameService();

    public void run() throws IllegalArgumentException {
        setGame();
    }

    private void setGame() {
        gameService.setGame(SIZE, START_INCLUSIVE, END_INCLUSIVE);
    }

    private void startGame() throws IllegalArgumentException {
        gameService.playGame();
    }

    private void endGame() {
        SystemMessage.printGameOverMessage();
    }
}
