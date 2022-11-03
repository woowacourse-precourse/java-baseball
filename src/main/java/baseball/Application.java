package baseball;

import baseball.controller.GameController;
import baseball.util.GameLogic;
import baseball.validation.InputValidation;
import baseball.view.GameView;

public class Application {
    public static void main(String[] args) {
        GameController gameController = new GameController(new GameView(new InputValidation()), new GameLogic());
        gameController.startGame();
    }
}
