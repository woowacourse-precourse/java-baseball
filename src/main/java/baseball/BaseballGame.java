package baseball;

import baseball.inputter.NumberInputter;
import baseball.opponent.ComputerOpponent;
import baseball.printer.MessagePrinter;
import baseball.printer.NumberInputMessagePrinter;
import baseball.printer.StartMessagePrinter;

public class BaseballGame {

    private ComputerOpponent opponent;
    private MessagePrinter inputMessagePrinter;
    private NumberInputter numberInputter;

    public BaseballGame() {
        MessagePrinter startMessagePrinter = new StartMessagePrinter();
        this.inputMessagePrinter = new NumberInputMessagePrinter();
        this.opponent = new ComputerOpponent();
        startMessagePrinter.printMessage();
    }

    public void play() throws IllegalArgumentException {
        try {
            inputMessagePrinter.printMessage();
            Integer inputNumber = numberInputter.input();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
