package baseball.Controller;

import baseball.config.Assembler;
import baseball.domain.BaseBallService;
import baseball.view.MessagePrinter;

public class GameController {

    private final MessagePrinter messagePrinter;
    private final BaseBallService baseBallService;

    public GameController(Assembler assembler){
        messagePrinter = assembler.messagePrinter();
        baseBallService = assembler.baseBallService();

    }

    public void run(){
        messagePrinter.printGameStart();
        baseBallService.selectRandomNumbers();
    }
}
