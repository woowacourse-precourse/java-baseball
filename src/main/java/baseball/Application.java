package baseball;


import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.Game;
import baseball.domain.Player;


public class Application {

    public static void main(String[] args) {
        GameController gameController = new GameController(new Game(), new Player(), new Computer());
        gameController.run();
    }
}
