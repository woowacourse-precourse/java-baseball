package baseball.controller;

import baseball.model.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.utils.GameMessage.*;

public class BaseballController {
    private final static String ANSWER_RESULT = "3스트라이크\n";
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;

    public BaseballController(InputView inputView, OutputView outputView, Computer computer) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
    }

    public void runGame() {
        outputView.showGameMessage(START);
        boolean flag = true;
        while (flag) {
            List<Integer> randomNumbers = computer.generateRandomNumbers();
            runSubGame(randomNumbers);
            outputView.showGameMessage(QUESTION);
            if (!inputView.questionInput()) {
                flag = false;
            }
        }
    }

    public void runSubGame(List<Integer> randomNumbers) {
        String countResult = "";
        while (!countResult.equals(ANSWER_RESULT)) {
            outputView.showGameMessage(REQUEST);
            List<Integer> userNumbers = inputView.requestInput();

            countResult = computer.generateCountResult(randomNumbers, userNumbers);
            outputView.showGameMessage(countResult);
        }
        outputView.showGameMessage(ANSWER);
    }
}
