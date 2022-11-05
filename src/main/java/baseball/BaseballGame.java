package baseball;

import baseball.inputter.BaseballGameNumberInputter;
import baseball.opponent.ComputerOpponent;
import baseball.printer.MessagePrinter;
import baseball.printer.NumberInputMessagePrinter;
import baseball.printer.StartMessagePrinter;

import java.util.List;

public class BaseballGame {

    private ComputerOpponent opponent;
    private MessagePrinter inputMessagePrinter;
    private BaseballGameNumberInputter numberInputter;

    public BaseballGame() {
        MessagePrinter startMessagePrinter = new StartMessagePrinter();
        this.inputMessagePrinter = new NumberInputMessagePrinter();
        this.opponent = new ComputerOpponent();
        startMessagePrinter.printMessage();
    }

    public void play() throws IllegalArgumentException {
        try {
            inputMessagePrinter.printMessage();
            List<Integer> inputNumber = numberInputter.inputThreeNumbers();
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }
}
