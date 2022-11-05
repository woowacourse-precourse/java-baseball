package baseball;

import baseball.console.GameConsole;
import baseball.converter.ThreeNumberConverter;
import baseball.dto.BallStrikeDto;
import baseball.opponent.ComputerOpponent;
import baseball.opponent.RandomNumberGenerator;
import baseball.printer.GameMessagePrinter;

import java.util.List;

public class BaseballGame {

    private ComputerOpponent opponent;
    private ThreeNumberConverter threeNumberConverter;
    private GameMessagePrinter messagePrinter;
    private GameConsole console;

    public BaseballGame() {
        this.messagePrinter = new GameMessagePrinter();
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());

        messagePrinter.printStartMessage();
    }

    public void play() throws IllegalArgumentException {
        try {
            messagePrinter.printNumberInputMessage();
            List<Integer> threeNumbers = threeNumberConverter.getThreeNumbers(console.input());
            BallStrikeDto answer = opponent.answer(threeNumbers);
            messagePrinter.printResultMessage(answer);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
