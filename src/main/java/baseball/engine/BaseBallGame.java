package baseball.engine;

import baseball.io.ConsoleOutput;

public class BaseBallGame implements Runnable {
    private final ConsoleOutput output;

    public BaseBallGame(ConsoleOutput output) {
        this.output = output;
    }

    @Override
    public void run() {
        output.printStartText();
    }
}
