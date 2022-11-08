package baseball;

import baseball.UI.HintView;
import baseball.UI.InputView;
import baseball.UI.ResultView;
import baseball.controller.Controller;
import baseball.service.Service;

public class Application {
    public static void main(String[] args) {

        Controller controller = new Controller();
        controller.playGame();
    }
}
