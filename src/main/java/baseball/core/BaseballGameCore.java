package baseball.core;

import baseball.console.GameConsole;
import baseball.core.dto.BallStrikeDto;
import baseball.core.opponent.RandomNumberGenerator;

import java.util.List;

public class BaseballGameCore {

    private ComputerOpponent opponent;
    private final GameConsole console;

    public BaseballGameCore(GameConsole console) {
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
        console.printNumberInputMessage();
        return console.inputThreeNumbers();
    }

    private BallStrikeDto checkProcess(List<Integer> threeNumbers) {
        BallStrikeDto answer = opponent.answer(threeNumbers);
        console.printResultMessage(answer);
        return answer;
    }

    private boolean isFinished(BallStrikeDto answer) {
        return answer.getStrikeCount() == 3;
    }

    private void finishProcess() {
        console.printFinishMessage();
    }
}
