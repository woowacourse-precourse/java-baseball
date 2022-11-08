package baseball.controller;

import baseball.model.Computer;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.utils.GameMessage.*;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;
    private final FlowController flowController;

    public BaseballController(InputView inputView, OutputView outputView, Computer computer,FlowController flowController) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
        this.flowController = flowController;
    }

    public void runGame() {
        outputView.showGameMessage(START);
        while (flowController.getGameFlag()) {

            List<Integer> randomNumbers = computer.generateRandomNumbers();

            runSubGame(randomNumbers);

            outputView.showGameMessage(QUESTION);

            Boolean isAgain = inputView.questionInput();
            flowController.setGameFlag(isAgain);
        }
    }

    public void runSubGame(List<Integer> randomNumbers) {
        while (flowController.getSubGameFlag()) {

            outputView.showGameMessage(REQUEST);

            List<Integer> userNumbers = inputView.requestInput();

            String countResult = computer.generateCountResult(randomNumbers, userNumbers);
            outputView.showGameMessage(countResult);
            flowController.setSubGameFlag(countResult);
        }
        flowController.setSubGameFlag();
        outputView.showGameMessage(ANSWER);
    }
}
