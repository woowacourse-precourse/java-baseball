package baseball;

import baseball.controller.StartController;

public class Application {
    public static void main(String[] args) {
        StartController startController = new StartController();
        startController.run();
    }
}
