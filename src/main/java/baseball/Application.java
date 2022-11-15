package baseball;


import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.Game;


public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new Game(), Computer.createComputer());
        gameController.run();
    }
}
