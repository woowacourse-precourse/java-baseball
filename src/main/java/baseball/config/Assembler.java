package baseball.config;

import baseball.domain.BaseBallService;
import baseball.domain.BaseBallServiceImpl;
import baseball.domain.Verification;
import baseball.domain.VerificationImpl;
import baseball.domain.repository.NumberRepository;
import baseball.domain.repository.NumberRepositoryImpl;
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
    public Verification verification(){
        return new VerificationImpl();
    }
}
