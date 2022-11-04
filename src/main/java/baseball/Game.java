package baseball;

import baseball.Players.Computer;
import baseball.Players.User;
import baseball.Utils.Printer;

import java.util.List;

public class Game {

    private final Printer print;

    private Computer computer;
    private User user;

    public Game() {
        this.print = new Printer();
        this.computer = new Computer();
        this.user = new User();
    }

    public void start(boolean isFirstGame) {
        if (isFirstGame) {
            print.gameStart();
        }

        print.inputNumbers();

        List<Integer> answerNumbers = computer.getRamdomNumbers();
        List<Integer> userNumbers = user.getInputNumbers();

        end();
    }

    private void end() {

    }
}
