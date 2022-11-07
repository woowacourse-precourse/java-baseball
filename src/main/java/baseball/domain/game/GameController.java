package baseball.domain.game;

import baseball.domain.computer.Computer;
import baseball.domain.user.User;
import baseball.domain.view.OutputView;

public class GameController {
    public GameController() {
        start();
        Computer computer = ongoing();
        end(computer);
    }

    private static void start() {
        OutputView.printStart();
    }

    private static Computer ongoing() {
        Computer computer = new Computer();
        String randomNumbers = computer.numbers;
        new User(randomNumbers);
        return computer;
    }

    private static void end(Computer computer) {
        OutputView.printEnd();
        computer.restartGameInputOneOrElseEndGame();
    }
}