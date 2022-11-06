package baseball.config;

import baseball.domain.BaseBallService;
import baseball.domain.BaseBallServiceImpl;
import baseball.domain.entity.NumberRepository;
import baseball.domain.entity.NumberRepositoryImpl;
import baseball.view.MessagePrinter;
import baseball.view.MessagePrinterImpl;

public class Assembler {


    public MessagePrinter messagePrinter(){
        return new MessagePrinterImpl();
    }
    public BaseBallService baseBallService() {
        return new BaseBallServiceImpl();
    }

    public NumberRepository numberRepository(){
        return new NumberRepositoryImpl();
    }
}
