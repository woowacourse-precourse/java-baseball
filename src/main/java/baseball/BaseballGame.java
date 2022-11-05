package baseball;

import baseball.console.GameConsole;
import baseball.converter.RestartOrExitCodeConverter;
import baseball.converter.ThreeNumberConverter;
import baseball.dto.BallStrikeDto;
import baseball.opponent.ComputerOpponent;
import baseball.opponent.RandomNumberGenerator;
import baseball.printer.GameMessagePrinter;

import java.util.List;

import static baseball.converter.RestartOrExitCodeConverter.EXIT_CODE;

public class BaseballGame {

    private ComputerOpponent opponent;
    private ThreeNumberConverter threeNumberConverter;
    private RestartOrExitCodeConverter codeConverter;
    private GameMessagePrinter messagePrinter;
    private GameConsole console;

    public BaseballGame() {
        this.messagePrinter = new GameMessagePrinter();
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());
        this.threeNumberConverter = new ThreeNumberConverter();
        this.codeConverter = new RestartOrExitCodeConverter();
        this.console = new GameConsole();
        messagePrinter.printStartMessage();
    }

    public void play() throws IllegalArgumentException {
        while (true) {
            try {
                while (true) {
                    messagePrinter.printNumberInputMessage();
                    List<Integer> threeNumbers = threeNumberConverter.getThreeNumbers(console.input());
                    BallStrikeDto answer = opponent.answer(threeNumbers);
                    messagePrinter.printResultMessage(answer);
                    if (answer.getStrikeCount() == 3) {
                        messagePrinter.printFinishMessage();
                        break;
                    }
                }
                messagePrinter.printRestartOrExitMessage();
                int statusCode = codeConverter.getRestartOrExitCode(console.input());
                if (statusCode == EXIT_CODE) {
                    break;
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
