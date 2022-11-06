package baseball.core;

import baseball.console.GameConsole;
import baseball.core.dto.BallStrikeDto;
import baseball.core.opponent.ComputerOpponent;
import baseball.core.opponent.RandomNumberGenerator;
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
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());
        while (true) {
            List<Integer> threeNumbers = inputProcess();
            BallStrikeDto answer = checkProcess(threeNumbers);
            if (isFinished(answer)) {
                break;
            }
        }
        finishProcess();
    }

    private List<Integer> inputProcess() {
        messagePrinter.printNumberInputMessage();
        return console.inputThreeNumbers();
    }

    private BallStrikeDto checkProcess(List<Integer> threeNumbers) {
        BallStrikeDto answer = opponent.answer(threeNumbers);
        messagePrinter.printResultMessage(answer);
        return answer;
    }

    private boolean isFinished(BallStrikeDto answer) {
        return answer.getStrikeCount() == 3;
    }

    private void finishProcess() {
        messagePrinter.printFinishMessage();
    }
}
