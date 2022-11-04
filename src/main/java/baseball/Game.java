package baseball;

import baseball.Players.Computer;
import baseball.Players.User;

import java.util.List;

public class Game {

    private Computer computer;
    private User user;

    public Game() {
        this.computer = new Computer();
        this.user = new User();
    }

    public void start(boolean isFirstGame) {
        List<Integer> answerNumbers = computer.getRamdomNumbers();
        List<Integer> userNumbers = user.getInputNumbers();

        end();
    }

    private void end() {

    }
}
