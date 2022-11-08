package baseball;

import baseball.baseball.BaseBallController;
import baseball.baseball.BaseBallService;

public class Application {

    public static void main(String[] args) {
        BaseBallController baseBallController = new BaseBallController();
        baseBallController.gameFlow();
    }
}
