package baseball.controller;

import baseball.domain.BallFactory;
import baseball.domain.Balls;
import baseball.domain.generator.NumberGenerator;
import baseball.domain.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    public void run() {
        playGame();
        endGame();
    }

    private void playGame() {
        OutputView.printStartMessage();
        playRounds(getAnswer());
    }

    private void playRounds(Balls answer) {
        PlayResult playResult = getPlayerBalls().play(answer);
        OutputView.printResult(playResult);
        if (playResult.isGameEnd()) {
            return;
        }
        playRounds(answer);
    }

    private void endGame() {
        OutputView.printEndMessage();
        if (InputView.yesOrNo()) {
            run();
        }
    }

    private Balls getAnswer() {
        List<Integer> numbers = NumberGenerator.generateRandomNumbers();
        return BallFactory.createBalls(numbers);
    }

    private Balls getPlayerBalls() {
        List<Integer> numbers = InputView.getInput();
        return BallFactory.createBalls(numbers);
    }


 }
