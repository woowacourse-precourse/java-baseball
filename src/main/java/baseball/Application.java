package baseball;

import baseball.domain.GameController;

public class Application {
    public static void main(String[] args) {
        GameController gc = GameController.getInstance();
        gc.run();
    }
}
