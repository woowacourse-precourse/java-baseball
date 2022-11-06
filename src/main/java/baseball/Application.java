package baseball;

import baseball.service.GAME_RESULT;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        GameService.finishNumber = GAME_RESULT.START_GAME;
        while (GameService.finishNumber != GAME_RESULT.END_GAME) {
            GameService gameService = new GameService();
            gameService.startGame();
        }
    }

    
}
