package baseball.controller;

import java.util.List;

import baseball.domain.ComputerNumber;
import baseball.service.JudgeGame;
import baseball.util.ValidationUtil;
import baseball.view.OutputView;

public class GameController {
    public void startGame() {
        ComputerNumber computerNumber = new ComputerNumber();
        List<Integer> computerNumberList = computerNumber.computerNumberList;
        OutputView.printGameStart();

        while (true) {
            String input = OutputView.printRequestNumber();
            ValidationUtil.validateInputNumber(input);
            List<Integer> inputNumberList = JudgeGame.getInputNumberList(input);

            if (!JudgeGame.verifyAnswer(inputNumberList, computerNumberList)) {
                break;
            }
        }
    }
}
