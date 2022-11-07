package baseball;

import baseball.controller.BaseBallController;
import baseball.service.BaseBallService;

public class Application {
    public static void main(String[] args) {
        BaseBallController controller = new BaseBallController(new BaseBallService());
        controller.run();
    }
}
