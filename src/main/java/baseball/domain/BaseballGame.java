package baseball.domain;

import baseball.io.Console;
import baseball.util.ValidatorImpl;

public class BaseballGame {
    private final Console console;
    private final Computer computer;
    private final Referee referee;

    public BaseballGame() {
        this.console = new Console(new ValidatorImpl());
        this.computer = new Computer();
        this.referee = new Referee();
    }

    public void start() {
        do {
            printHint();
        } while (!isGameOver());
    }

    private void printHint() {
        referee.getHint(console.getUserNumber(), computer.getComputerNumber());
    }

    public boolean isGameOver() {
        return referee.isThreeStrike();
    }
}
