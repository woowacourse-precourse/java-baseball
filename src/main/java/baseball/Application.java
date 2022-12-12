package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {

    private static BaseballController baseballController;

    public static void main(String[] args) {
        init();
        baseballController.turnOn();
        baseballController.newGame();
        baseballController.bettingForm();
    }

    private static void init() {
        baseballController = new BaseballController(new InputView(), new OutputView(), new BaseballService());
    }

}
