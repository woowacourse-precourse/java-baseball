package baseball;

import baseball.controller.BaseballGameController;

public class Application {
    public static void main(String[] args) throws IllegalArgumentException{
        BaseballGameController controller = new BaseballGameController();

        try {
            controller.run();
        } catch (IllegalArgumentException e) {
        }
    }
}
