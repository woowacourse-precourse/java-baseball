package baseball.controller;

import baseball.serviceImpl.GameService;

public class GameController {
    public void startGame(){
        GameService game = new GameService();
        game.starGame();
    }
}
