package baseball.config;

import baseball.domain.BaseBallService;
import baseball.domain.BaseBallServiceImpl;
import baseball.view.MessagePrinter;
import baseball.view.MessagePrinterImpl;

public class Assembler {


    public MessagePrinter messagePrinter(){
        return new MessagePrinterImpl();
    }
    public BaseBallService baseBallService() {
        return new BaseBallServiceImpl();
    }
}
