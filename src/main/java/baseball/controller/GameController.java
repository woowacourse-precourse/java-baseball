package baseball.controller;

import baseball.service.GameService;
import baseball.view.SystemMessage;

public class GameController {

    private static final int GAME_NUMBER_DIGIT = 3;
    private static final int MINIMUM_NUMBER = 1;
    private static final int MAXIMUM_NUMBER = 9;

    GameService gameService = new GameService();
    SystemMessage systemMessage = new SystemMessage();

    public void startGame() {

        systemMessage.showStartMessage();
        gameService.setGame(GAME_NUMBER_DIGIT, MINIMUM_NUMBER, MAXIMUM_NUMBER);

        while (true) {
            gameService.getUserInputs();
            gameService.countStrikeAndBall();

            if (gameService.makeResult()) {
                break;
            }
        }

        if (gameService.restartOrExit()) {
            startGame();
        }
    }

}
