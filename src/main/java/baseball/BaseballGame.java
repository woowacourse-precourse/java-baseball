package baseball;

import baseball.console.GameConsole;
import baseball.core.BaseballGameCore;

import static baseball.console.input.converter.RestartOrExitCodeConverter.EXIT_CODE;
import static baseball.console.input.converter.RestartOrExitCodeConverter.START_CODE;

public class BaseballGame {

    private final GameConsole console;
    private final BaseballGameCore gameCore;

    public BaseballGame() {
        this.console = new GameConsole();
        this.gameCore = new BaseballGameCore(console);
    }

    public void play() throws IllegalArgumentException {
        int statusCode = START_CODE;

        console.printStartMessage();
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
        console.printRestartOrExitMessage();
        return console.inputCode();
    }

    private boolean isNotExitCode(int statusCode) {
        return statusCode != EXIT_CODE;
    }
}
