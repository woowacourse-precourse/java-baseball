package baseball;

import baseball.controller.StartController;

public class Application {
    private static final int EXIT_CODE = 2;
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        StartController startController = new StartController();
        do {
            startController.startGame();
        } while(startController.askOneMore() != EXIT_CODE);
    }
}
