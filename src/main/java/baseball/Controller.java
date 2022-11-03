package baseball;

import baseball.service.Service;
import baseball.view.SystemMessage;

public class Controller {
    Service service = new Service();

    public void run() {
        boolean gameEnd = false;
        SystemMessage.printGameStart();
        while (!gameEnd) {
            service.setGame();
            service.startGame();
            gameEnd = service.finishGame();
        }
    }
}
