package baseball;

import baseball.service.Service;

public class Controller {
    Service service = new Service();

    public void run() {
        service.setGame();
        service.startGame();
    }
}
