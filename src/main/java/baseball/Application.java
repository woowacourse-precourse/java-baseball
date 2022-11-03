package baseball;

import baseball.controller.BaseballController;
import baseball.service.BaseballService;
import baseball.view.BaseballView;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new BaseballView(), new BaseballService());
        baseballController.run();
    }
}
