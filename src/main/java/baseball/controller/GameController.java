package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.AnswerGenerator;
import baseball.domain.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
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
        List<Integer> numbers = AnswerGenerator.createAnswer();
        return convertToBalls(numbers);
    }

    private Balls getPlayerBalls() {
        List<Integer> numbers = InputView.getInput();
        return convertToBalls(numbers);
    }

    private static Balls convertToBalls(List<Integer> numbers) {
        List<Ball> ballList = new ArrayList<>();
        for (int i = 0; i < numbers.size(); i++) {
            ballList.add(Ball.of(numbers.get(i), i + 1));
        }
        return Balls.of(ballList);
    }
}
