package baseball;

import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.number.RandomNumberGenerator;
import baseball.util.number.InputNumberGenerator;

public class Application {
    public static void main(String[] args) {
      GameController gameController = new GameController(new User(new InputNumberGenerator()), new Computer(new RandomNumberGenerator()));
      gameController.run();
    }
}
