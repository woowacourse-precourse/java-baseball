package baseball;

import baseball.gameComponents.GameManager;
import baseball.gameComponents.GameComponent;
import baseball.gameComponents.Validator;

public class Application {

    public static void main(String[] args) {
        Validator validator = new Validator();
        GameComponent gameComponent = new GameComponent(validator);
        GameManager gameManager = new GameManager(gameComponent, validator);

        gameManager.gameStart();
    }
}
