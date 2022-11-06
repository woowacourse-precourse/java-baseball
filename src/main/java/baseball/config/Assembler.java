package baseball.config;

import baseball.view.MessagePrinter;
import baseball.view.MessagePrinterImpl;

public class Assembler {

    private final MessagePrinter messagePrinter;

    public Assembler(){
        this.messagePrinter = new MessagePrinterImpl();
    }

    public MessagePrinter getMessagePrinter(){
        return messagePrinter;
    }
}
