package baseball.controller;

import baseball.domain.ball.Balls;
import baseball.domain.generator.NumberGenerator;
import baseball.domain.result.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.List;

public class GameController {

    public void run() {
        OutputView.printStartMessage();
        playGame();
    }

    private void playGame() {
        playRounds(getAnswer());
        endGame();
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
        if (InputView.yesOrNo()) {
            playGame();
        }
    }

    private Balls getAnswer() {
        List<Integer> numbers = NumberGenerator.generateRandomNumbers();
        return Balls.of(numbers);
    }

    private Balls getPlayerBalls() {
        List<Integer> numbers = InputView.getInput();
        return Balls.of(numbers);
    }
}