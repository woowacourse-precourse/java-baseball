package baseball;

import baseball.console.GameConsole;
import baseball.converter.ThreeNumberConverter;
import baseball.opponent.ComputerOpponent;
import baseball.printer.MessagePrinter;
import baseball.printer.NumberInputMessagePrinter;
import baseball.printer.StartMessagePrinter;

import java.util.List;

public class BaseballGame {

    private ComputerOpponent opponent;
    private MessagePrinter inputMessagePrinter;
    private ThreeNumberConverter threeNumberConverter;
    private GameConsole console;

    public BaseballGame() {
        MessagePrinter startMessagePrinter = new StartMessagePrinter();
        this.inputMessagePrinter = new NumberInputMessagePrinter();
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());
        startMessagePrinter.printMessage();
    }

    public void play() throws IllegalArgumentException {
        try {
            inputMessagePrinter.printMessage();
            List<Integer> threeNumbers = threeNumberConverter.getThreeNumbers(console.input());
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
