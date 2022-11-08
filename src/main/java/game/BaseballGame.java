package game;

import camp.nextstep.edu.missionutils.Console;
import game.util.Compare;
import game.player.Computer;
import game.player.User;
import game.util.Print;
import game.util.Validate;

public class BaseballGame {
    private Computer computer;
    private User user;

    public BaseballGame() {
    }

    public void start() throws IllegalArgumentException {
        ready();
        roundWithComputer();
        if (again()) {
            start();
        }
    }

    private void ready() {
        computer = new Computer();
        Print.printGettingStart();
    }

    private void readNumbers() throws IllegalArgumentException {
        Print.printReadNumbers();
        user = new User();
    }

    private void roundWithComputer() throws IllegalArgumentException {
        readNumbers();

        Compare c = new Compare();
        if (!c.isStrikeOut(computer, user)) {
            roundWithComputer();
        }
    }

    private boolean again() throws IllegalArgumentException {
        Print.printGameOverAndAfterRound();
        return Validate.readOneOrTwo(Console.readLine()) == 1;
    }
}
