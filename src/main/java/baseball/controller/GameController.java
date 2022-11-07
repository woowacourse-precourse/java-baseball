package baseball.controller;

import baseball.service.GameService;

public class GameController {
    public void startGame(){
        GameService game = new GameService();
        game.starGame();
    }
}
