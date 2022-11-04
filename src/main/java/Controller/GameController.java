package Controller;

import Service.GameService;

public class GameController {
    private final int NUM_SIZE = 3;

    GameService gameService = new GameService();

    public void run(){
        startGame();
        playGame();
        endGame();
        askContinue();
    }
}
