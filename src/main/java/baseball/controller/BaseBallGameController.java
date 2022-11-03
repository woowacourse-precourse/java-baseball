package baseball.controller;

import baseball.domain.PlayResult;
import baseball.domain.Referee;
import baseball.utils.ComputerBallGenerator;
import baseball.utils.UserInputConvertor;
import baseball.utils.UserInputValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseBallGameController {

    public void startGame() {
        do {
            playGame();
        } while (InputView.decideContinueGame());
    }

    private void playGame() {
        List<Integer> computerBalls = ComputerBallGenerator.generateComputerBalls();
        PlayResult playResult;
        do {
            List<Integer> userBalls = UserInputConvertor.mapToInt(InputView.receiveUserInput());
            UserInputValidator.isValidBalls(userBalls);
            Referee referee = new Referee(userBalls, computerBalls);
            playResult = referee.notifyResult();
            OutputView.printGameResult(playResult.getStrike(), playResult.getBall());
        } while (!gameEnd(playResult.getStrike()));
    }

    private boolean gameEnd(int strike) {
        return strike == UserInputValidator.INPUT_SIZE;
    }
}
