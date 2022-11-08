package baseball;

import baseball.contorller.GameController;
import baseball.domain.RandomNumber;
import baseball.service.GameService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        GameService service = new GameService(new RandomNumber());
        GameController controller = new GameController(service);

        controller.start();
    }
}
