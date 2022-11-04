package baseball;

import baseball.Controller;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        Controller controller = new Controller();
        controller.playGame();
    }
}
