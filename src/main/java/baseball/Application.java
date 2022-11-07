package baseball;

import baseball.controller.BaseballGameController;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        BaseballGameController baseballGameController = new BaseballGameController();
        OutputView.printStartBaseballGame();
        do {
            baseballGameController.start();
        } while (baseballGameController.keepGoingOrDone());
        OutputView.printEndBaseballGameMessage();
    }
}
