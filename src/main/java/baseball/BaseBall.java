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
    private boolean isCorrect;

    public void playGame() {
        System.out.println(Messages.gameStart);
        numberOfComputer = computer.make();
        isCorrect = false;
        while (!isCorrect) {
            roundOfGame();
        }
    }

    private void roundOfGame() {
        System.out.println(Messages.inputNumber);
        numberOfUser = user.input();

        Result result = new Result(numberOfComputer, numberOfUser);
        this.isCorrect = result.isThreeStrike();

        System.out.println(result.getResult());
    }

}
