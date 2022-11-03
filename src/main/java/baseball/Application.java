package baseball;

import baseball.controller.GameController;
import baseball.util.GameLogic;
import baseball.validation.InputValidation;
import baseball.view.GameView;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        GameController gameController = new GameController(new GameView(new InputValidation()), new GameLogic());
        gameController.startGame();
    }
}
