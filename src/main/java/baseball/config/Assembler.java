package baseball.config;

import baseball.domain.BaseBallService;
import baseball.domain.BaseBallServiceImpl;
import baseball.view.MessagePrinter;
import baseball.view.MessagePrinterImpl;

public class Assembler {

    private final MessagePrinter messagePrinter;
    private final BaseBallService baseBallService;

    public Assembler(){
        this.messagePrinter = new MessagePrinterImpl();
        this.baseBallService = new BaseBallServiceImpl();
    }

    public MessagePrinter getMessagePrinter(){
        return messagePrinter;
    }
    public BaseBallService getBaseBallService() {
        return baseBallService;
    }
}
