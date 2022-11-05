package baseball;

import baseball.console.GameConsole;
import baseball.dto.BallStrikeDto;
import baseball.opponent.ComputerOpponent;
import baseball.opponent.RandomNumberGenerator;
import baseball.printer.GameMessagePrinter;

import java.util.List;

import static baseball.converter.RestartOrExitCodeConverter.EXIT_CODE;

public class BaseballGame {

    private final ComputerOpponent opponent;
    private final GameMessagePrinter messagePrinter;
    private final GameConsole console;

    public BaseballGame() {
        this.messagePrinter = new GameMessagePrinter();
        this.opponent = new ComputerOpponent(RandomNumberGenerator.generate());
        this.console = new GameConsole();
    }

    public void play() throws IllegalArgumentException {
        boolean cycleFlag = true;

        messagePrinter.printStartMessage();
        while (cycleFlag) {
            cycleFlag = playGameCycle();
        }
    }

    private boolean playGameCycle() {
        try {
            playBaseballGame();
            int statusCode = restartOrExitProcess();
            if (isExitCode(statusCode)) {
                return false;
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        return true;
    }

    private int restartOrExitProcess() {
        messagePrinter.printRestartOrExitMessage();
        return console.inputCode();
    }

    private void playBaseballGame() {
        while (true) {
            List<Integer> threeNumbers = inputProcess();
            BallStrikeDto answer = checkProcess(threeNumbers);
            if (isFinish(answer)) {
                finishProcess();
                break;
            }
        }
    }

    private boolean isExitCode(int statusCode) {
        return statusCode == EXIT_CODE;
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
