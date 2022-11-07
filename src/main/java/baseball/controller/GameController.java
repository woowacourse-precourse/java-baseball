package baseball.controller;

public class GameController {
    ComputerController computerController = new ComputerController();

    public void gameProcess() {
        computerController.startGame();
    }
}
