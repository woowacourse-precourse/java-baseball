package baseball.controller;

import baseball.service.GameService;
import baseball.view.SystemMessage;

public class GameController {

    private static final int GAME_NUMBER_DIGIT = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    GameService gameService = new GameService();

    public void startGame() {

        gameService.setGame(GAME_NUMBER_DIGIT, MINIMUM_NUMBER, MAXIMUM_NUMBER);

         do {
            gameService.getUserInputs();
            gameService.countStrikeAndBall();

        } while (!gameService.makeResult());

        if (gameService.restartOrExit()) {
            startGame();
        }
    }

}
