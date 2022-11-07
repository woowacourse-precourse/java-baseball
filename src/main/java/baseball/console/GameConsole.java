package baseball.console;

import baseball.console.input.ConsoleInput;
import baseball.console.output.ConsoleOutput;
import baseball.core.StatusCode;
import baseball.core.dto.BallStrikeDto;

import java.util.List;

public class GameConsole {

    private final ConsoleInput input;
    private final ConsoleOutput output;

    public GameConsole() {
        this.input = new ConsoleInput();
        this.output = new ConsoleOutput();
    }

    public List<Integer> inputThreeNumbers() {
        return input.inputThreeNumbers();
    }

    public StatusCode inputCode() {
        return input.inputCode();
    }

    public void printStartMessage() {
        output.printStartMessage();
    }

    public void printNumberInputMessage() {
        output.printNumberInputMessage();
    }

    public void printResultMessage(BallStrikeDto dto) {
        output.printResultMessage(dto);
    }

    public void printFinishMessage() {
        output.printFinishMessage();
    }

    public void printRestartOrExitMessage() {
        output.printRestartOrExitMessage();
    }
}
