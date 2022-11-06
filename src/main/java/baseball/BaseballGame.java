package baseball;

import baseball.console.GameConsole;
import baseball.core.BaseballGameCore;
import baseball.console.output.ConsoleOutput;

import static baseball.console.input.converter.RestartOrExitCodeConverter.EXIT_CODE;
import static baseball.console.input.converter.RestartOrExitCodeConverter.START_CODE;

public class BaseballGame {

    private final ConsoleOutput messagePrinter;
    private final GameConsole console;
    private final BaseballGameCore gameCore;

    public BaseballGame() {
        this.messagePrinter = new ConsoleOutput();
        this.console = new GameConsole();
        this.gameCore = new BaseballGameCore(messagePrinter, console);
    }

    public void play() throws IllegalArgumentException {
        int statusCode = START_CODE;

        messagePrinter.printStartMessage();
        while (isNotExitCode(statusCode)) {
             statusCode = playGameCycle();
        }
    }

    private int playGameCycle() {
        try {
            gameCore.playBaseballGame();
            return restartOrExitProcess();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private int restartOrExitProcess() {
        messagePrinter.printRestartOrExitMessage();
        return console.inputCode();
    }

    private boolean isNotExitCode(int statusCode) {
        return statusCode != EXIT_CODE;
    }
}
