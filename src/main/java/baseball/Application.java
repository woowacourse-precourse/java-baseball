package baseball;

import baseball.controller.GameController;
import baseball.domain.Computer;
import baseball.domain.User;
import baseball.util.number.ComputerNumberGenerator;
import baseball.util.number.UserNumberGenerator;

public class Application {
    public static void main(String[] args) {
      GameController gameController = new GameController(new User(new UserNumberGenerator()), new Computer(new ComputerNumberGenerator()));
      gameController.run();
    }
}
