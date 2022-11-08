package baseball;

import baseball.controller.BaseballController;
import baseball.model.Computer;
import baseball.model.Flow;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        BaseballController baseballController = new BaseballController(new InputView(), new OutputView(), new Computer(), new Flow());
        baseballController.runGame();
    }
}
