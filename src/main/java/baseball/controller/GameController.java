package baseball.controller;

import baseball.domain.Ball;
import baseball.domain.Balls;
import baseball.domain.ComputerBallGenerator;
import baseball.view.InputView;
import java.util.ArrayList;
import java.util.List;

public class GameController {

    ComputerBallGenerator generator = new ComputerBallGenerator();

    public void run() {
        Balls answer = getComputerBalls();
        Balls playerBalls = getPlayerBalls();

    }

    private Balls getComputerBalls() {
        List<Integer> numbers = generator.createComputerBalls();
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
