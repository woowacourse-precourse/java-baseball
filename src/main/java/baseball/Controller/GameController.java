package baseball.Controller;

import baseball.config.Assembler;
import baseball.domain.BaseBallService;
import baseball.domain.GameResult;
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
        selectRandomNumber();
        gaming();
    }

    public void gaming(){
        List<Integer> userInputNumbers = inputNumber();
        GameResult gameResult = baseBallService.compareNumbers(userInputNumbers);
        String message = gameResult.getResultMessage();
        messagePrinter.printGameResult(message);
        if(gameResult.isGameEnd()){
            gameEnd();
            return;
        }
        gaming();
    }

    private void selectRandomNumber(){
        List<Integer> selectedNumber = baseBallService.selectRandomNumbers();
        baseBallService.saveRandomNumbers(selectedNumber);
    }

    private void gameEnd(){
        messagePrinter.printGameEnd();
        messagePrinter.printQuestionGameRestart();
        requestInputRestartNumber();
    }

    public void requestInputRestartNumber(){
        String input = baseBallService.inputString();
        if(input.equals("1")) {
            selectRandomNumber();
            gaming();
        }
    }

    public List<Integer> inputNumber() {
        messagePrinter.printReqGameNumbersInput();
        String input = baseBallService.inputString();
        baseBallService.verify(input);

        return baseBallService.stringToIntegerList(input);
    }

}
