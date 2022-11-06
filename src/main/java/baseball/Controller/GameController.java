package baseball.Controller;

import baseball.config.Assembler;
import baseball.view.MessagePrinter;

public class GameController {

    private final MessagePrinter messagePrinter;

    public GameController(Assembler assembler){
        messagePrinter = assembler.getMessagePrinter();
    }

    public void run(){
        messagePrinter.printGameStart();
    }
}
