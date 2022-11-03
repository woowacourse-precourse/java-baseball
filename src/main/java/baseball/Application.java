package baseball;

import baseball.component.BaseballGameController;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController();
        baseballGameController.startGame();
    }
}
