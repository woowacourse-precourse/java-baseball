package baseball.controller;

import baseball.model.Computer;
import baseball.model.Flow;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

import static baseball.utils.GameMessage.*;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Computer computer;
    private final Flow flow;

    public BaseballController(InputView inputView, OutputView outputView, Computer computer, Flow flow) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.computer = computer;
        this.flow = flow;
    }

    public void runGame() {
        outputView.showGameMessage(START);
        while (flow.getGameFlag()) {

            List<Integer> randomNumbers = computer.generateRandomNumbers();

            runSubGame(randomNumbers);

            outputView.showGameMessage(QUESTION);

            Boolean isAgain = inputView.questionInput();
            flow.setGameFlag(isAgain);
        }
    }

    public void runSubGame(List<Integer> randomNumbers) {
        while (flow.getSubGameFlag()) {

            outputView.showGameMessage(REQUEST);

            List<Integer> userNumbers = inputView.requestInput();

            String countResult = computer.generateCountResult(randomNumbers, userNumbers);
            outputView.showGameMessage(countResult);
            flow.setSubGameFlag(countResult);
        }
        flow.setSubGameFlag();
        outputView.showGameMessage(ANSWER);
    }
}
