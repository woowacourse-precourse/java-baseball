package baseball.Controller;

import baseball.Domain.*;
import baseball.Service.GameService;

public class GameController {
    public GameService gameService = new GameService();

    public int startGame() {
        Computer com = new Computer();
        Player player = new Player();
        Hint result = new Hint();
        GameStatus gameStatus = GameStatus.PlAY;

        gameService.gameStart(com, player, result);
        gameService.makeComputerNum();

        do {
            gameService.getPlayerInput();
            gameService.countResult();
            gameService.showResult();

            if (gameService.checkIsAnswer()) {
                gameService.showEndMessage();
                gameStatus = gameService.askRestart();
            }

        } while (gameStatus == GameStatus.PlAY);
        return 0;
    }
}
