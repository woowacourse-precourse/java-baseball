package baseball.engine;

import baseball.io.ConsoleInput;
import baseball.io.ConsoleOutput;

public class BaseBallGame implements Runnable {
    private final ConsoleOutput output;
    private final ConsoleInput input;

    public BaseBallGame(ConsoleOutput output, ConsoleInput input) {
        this.output = output;
        this.input = input;
    }

    @Override
    public void run() {
        output.printStartText();
    }
}
