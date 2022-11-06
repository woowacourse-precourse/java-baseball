package baseball.controller;

import baseball.service.GameService;

public class GameController {
    GameService gameService = new GameService();

    public void runGame() {
        start();
        play();
        finish();
        replay();
    }

    public void play() {
        gameService.playGame();
    }

    public void start() {
        gameService.setGame();
    }

    public void finish() {
        gameService.endGame();
    }
    public void replay() {
        if (gameService.replayGame().equals("1")) {
            runGame();
        }
    }


}
