package baseball.controller;

import baseball.domain.Computer;
import baseball.view.OutputView;
import java.util.List;

public class BaseballController {
    private Computer computer = new Computer();

    private boolean isRightAnswer() {
        return computer.isAnswer();
    }

    private void printResultOf(List<Integer> randomNumbers, List<Integer> playerInputs) {
        String hintResult = hintResult(randomNumbers, playerInputs);
        OutputView.printHintResult(hintResult);
    }

    private String hintResult(List<Integer> randomNumbers, List<Integer> playerInputs) {
        return computer.resultOfGame(playerInputs, randomNumbers);
    }
}
