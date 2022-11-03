package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.ComputerBallGenerator;
import baseball.domain.PlayResult;
import baseball.view.InputView;
import baseball.view.OutputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    public void run() {
        OutputView.printStartMessage();
        PlayResult playResult = new PlayResult();
        Balls computerBalls = getComputerBalls();

        while (!playResult.isGameEnd()) {
            playResult = computerBalls.play(getPlayerBalls());
            OutputView.printResult(playResult);
        }

        OutputView.printEndMessage();
        if (InputView.yesOrNo()) {
            run();
        }
    }


    private Balls getComputerBalls() {
        List<Integer> numbers = ComputerBallGenerator.createComputerBalls();
        return getBalls(numbers);
    }

    private Balls getPlayerBalls() {
        List<Integer> numbers = InputView.inputPlayerNumber();
        return getBalls(numbers);
    }

    private static Balls getBalls(List<Integer> numbers) {
        List<Ball> ballList = new ArrayList<>();

        for (int i = 0; i < numbers.size(); i++) {
            ballList.add(Ball.of(numbers.get(i), i + 1));
        }
        return Balls.of(ballList);
    }
}
