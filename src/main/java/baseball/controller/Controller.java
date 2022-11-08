package baseball.controller;


import baseball.service.game.GameService;
import baseball.service.game.GameServiceImpl;

public class Controller {
    private final GameService gameService = new GameServiceImpl();

    public void run() {
        gameService.playGame();
    }
}
