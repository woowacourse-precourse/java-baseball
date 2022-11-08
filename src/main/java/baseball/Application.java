package baseball;

import static baseball.Constant.GAME_START;

import baseball.Controller.Controller;

public class Application {
    public static void main(String[] args) {
        System.out.println(GAME_START);
        Controller controller = new Controller();
        controller.run();
    }
}
