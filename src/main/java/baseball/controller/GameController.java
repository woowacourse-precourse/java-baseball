package baseball.controller;

import baseball.service.GameService;

public class GameController {
    private GameService gameService = new GameService();

    public void run(){
        start();
    }

    private void start(){
        gameService.start();
    }
}
