package baseball.core;

import baseball.console.GameConsole;
import baseball.dto.BallStrikeDto;
import baseball.opponent.ComputerOpponent;
import baseball.opponent.RandomNumberGenerator;
import baseball.printer.GameMessagePrinter;

import java.util.List;

public class BaseballGameCore {

    private final ComputerOpponent opponent;
    private final GameMessagePrinter messagePrinter;
    private final GameConsole console;

    public BaseballGameCore(GameMessagePrinter messagePrinter, GameConsole console) {
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());
        this.messagePrinter = messagePrinter;
        this.console = console;
    }

    public void playBaseballGame() {
        while (true) {
            List<Integer> threeNumbers = inputProcess();
            BallStrikeDto answer = checkProcess(threeNumbers);
            if (isFinish(answer)) {
                finishProcess();
                break;
            }
        }
    }

    private void finishProcess() {
        messagePrinter.printFinishMessage();
    }

    private boolean isFinish(BallStrikeDto answer) {
        return answer.getStrikeCount() == 3;
    }

    private BallStrikeDto checkProcess(List<Integer> threeNumbers) {
        BallStrikeDto answer = opponent.answer(threeNumbers);
        messagePrinter.printResultMessage(answer);
        return answer;
    }

    private List<Integer> inputProcess() {
        messagePrinter.printNumberInputMessage();
        return console.inputThreeNumbers();
    }
}
