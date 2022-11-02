package baseball;

import constant.Messages;
import domain.Computer;
import domain.Numbers;
import domain.User;

public class BaseBall {
    private Computer computer = new Computer();
    private User user = new User();
    private Numbers numberOfComputer;
    private Numbers numberOfUser;

    public void playGame() {
        System.out.println(Messages.gameStart);
        numberOfComputer = computer.make();
        do {
            roundOfGame();
        } while (isResume());
    }

    private void roundOfGame() {
        System.out.println(Messages.inputNumber);
        numberOfUser = user.input();

    }

    private boolean isResume() {

    }
}
