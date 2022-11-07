package baseball.console.input;

import baseball.core.StatusCode;
import baseball.console.input.converter.ThreeNumberConverter;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class ConsoleInput {

    private final ThreeNumberConverter threeNumberConverter;
    private final RestartOrExitCodeConverter codeConverter;

    public ConsoleInput() {
        this.threeNumberConverter = new ThreeNumberConverter();
        this.codeConverter = new RestartOrExitCodeConverter();
    }

    public List<Integer> inputThreeNumbers() {
        String inputString = input();
        return threeNumberConverter.getThreeNumbers(inputString);
    }

    public StatusCode inputCode() {
        return StatusCode.from(input());
        return codeConverter.getRestartOrExitCode(inputString);
    }

    private String input() {
        return Console.readLine();
    }
}
