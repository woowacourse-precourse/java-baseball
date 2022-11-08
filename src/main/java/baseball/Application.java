package baseball;

import baseball.Controller.GameController;
import baseball.config.Assembler;

public class Application {
    public static void main(String[] args) {

        Assembler assembler = new Assembler();
        GameController gameController = new GameController(assembler);
        gameController.run();
    }
}
