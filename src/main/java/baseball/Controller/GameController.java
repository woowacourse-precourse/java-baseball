package baseball.Controller;

import baseball.config.Assembler;
import baseball.domain.BaseBallService;
import baseball.view.MessagePrinter;

import java.util.List;

public class GameController {

    private final MessagePrinter messagePrinter;
    private final BaseBallService baseBallService;

    public GameController(Assembler assembler){
        messagePrinter = assembler.messagePrinter();
        baseBallService = assembler.baseBallService();
    }

    public void run(){
        messagePrinter.printGameStart();
        List<Integer> selectedNumber = baseBallService.selectRandomNumbers();
        baseBallService.saveRandomNumbers(selectedNumber);
        List<Integer> UserInputNumbers = inputNumber();
    }

    public List<Integer> inputNumber(){
        messagePrinter.printReqGameNumbersInput();
        String input = baseBallService.inputString();
        baseBallService.verify(input);

        return baseBallService.stringToIntegerList(input);
    }
}
