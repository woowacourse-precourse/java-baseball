package baseball;

import baseball.controller.GameController;
import baseball.controller.StartController;
import baseball.domain.Computer;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException {
        // TODO: 프로그램 구현
        Computer computer;
        GameController gameController;
        StartController startController;
        do {
            computer = new Computer();
            startController = new StartController();
            gameController = new GameController();
            computer = startController.startController();
            gameController.playGame(computer);
        } while(startController.askOneMore() == 1);
    }
}
