package baseball.controller;

import baseball.model.GameNumber;

public class GameController {
    GameNumber gameNumber = new GameNumber();
    ComputerController computerController = new ComputerController();

    public void gameProcess() {
        computerController.startGame(gameNumber);
    }
}
