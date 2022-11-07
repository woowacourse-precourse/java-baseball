package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.domain.view.OutputView;

public class GameController {
    public GameController() {
        OutputView.printStart();
        Computer computer = new Computer();
        String randomNumbers = computer.numbers;
        new User(randomNumbers);
        OutputView.printEnd();
        computer.restartGameInputOneOrElseEndGame();
    }
}