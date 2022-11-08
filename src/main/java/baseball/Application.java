package baseball;

import baseball.controller.BaseballGameController;
import baseball.domain.BaseballGameMachine;
import baseball.domain.BaseballNumbersFactory;

public class Application {
    public static void main(String[] args) {
        BaseballGameController baseballGameController = new BaseballGameController(
                new BaseballNumbersFactory(),
                new BaseballGameMachine()
        );

        baseballGameController.run();
    }
}
