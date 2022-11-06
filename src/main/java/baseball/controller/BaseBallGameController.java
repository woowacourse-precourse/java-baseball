package baseball.controller;

import baseball.domain.Balls;
import baseball.domain.PlayResult;
import baseball.domain.Referee;
import baseball.utils.ComputerBallGenerator;
import baseball.utils.BallConvertor;
import baseball.utils.BallValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseBallGameController {

    public void startGame() {
        InputView.startGame();
        do {
            playGame();
        } while (InputView.decideContinueGame());
    }

    private void playGame() {
        Balls computerBalls = new Balls(ComputerBallGenerator.generateComputerBalls());
        PlayResult playResult;
        do {
            List<Integer> userInput = BallConvertor.mapToInt(InputView.receiveUserInput());
            Balls userBalls = new Balls(userInput);
            Referee referee = new Referee(userBalls, computerBalls);
            playResult = referee.notifyResult();
            OutputView.printGameResult(playResult.getStrike(), playResult.getBall());
        } while (!gameEnd(playResult.getStrike()));
    }

    private boolean gameEnd(int strike) {
        return strike == BallValidator.MAX_BALL_SIZE;
    }
}
