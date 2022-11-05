package baseball;

import baseball.console.GameConsole;
import baseball.dto.BallStrikeDto;
import baseball.opponent.ComputerOpponent;
import baseball.opponent.RandomNumberGenerator;
import baseball.printer.GameMessagePrinter;

import java.util.List;

import static baseball.converter.RestartOrExitCodeConverter.EXIT_CODE;

public class BaseballGame {

    private final ComputerOpponent opponent;
    private final GameMessagePrinter messagePrinter;
    private final GameConsole console;

    public BaseballGame() {
        this.messagePrinter = new GameMessagePrinter();
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());
        this.console = new GameConsole();
        messagePrinter.printStartMessage();
    }

    public void play() throws IllegalArgumentException {
        while (true) {
            try {
                while (true) {
                    messagePrinter.printNumberInputMessage();
                    List<Integer> threeNumbers = console.inputThreeNumbers();
                    BallStrikeDto answer = opponent.answer(threeNumbers);
                    messagePrinter.printResultMessage(answer);
                    if (answer.getStrikeCount() == 3) {
                        messagePrinter.printFinishMessage();
                        break;
                    }
                }
                messagePrinter.printRestartOrExitMessage();
                int statusCode = console.inputCode();
                if (statusCode == EXIT_CODE) {
                    break;
                }
            } catch (Exception e) {
                throw new IllegalArgumentException(e.getMessage());
            }
        }
    }
}
