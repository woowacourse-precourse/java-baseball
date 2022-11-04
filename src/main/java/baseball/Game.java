package baseball;

import baseball.Players.Computer;
import baseball.Players.User;

import java.util.List;

public class Game {

    private Computer computer;

    public Game() {
        this.computer = new Computer();
    }

    public void start(boolean isFirstGame) {
        List<Integer> answerNumbers = computer.getRamdomNumbers();

        end();
    }

    private void end() {

    }
}
