package baseball.ball;

import baseball.game.GameResult;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private final int NUMBERS_SIZE = 3;
    private final int ZERO = 0;
    private List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> numbers) {
        validateNumbersSize(numbers);

        for (int i = ZERO; i < numbers.size(); i++) {
            Ball ball = new Ball(numbers.get(i), i);
            balls.add(ball);
        }
    }

    private void validateNumbersSize(List<Integer> numbers) {
        if (numbers.size() != NUMBERS_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public GameResult compare(Balls playerAnswer) {
        List<Ball> answers = playerAnswer.balls;
        GameResult gameResult = new GameResult();

        for (Ball ball : balls) {
            BallResult ballResult = answers.stream()
                    .map(answer -> answer.compare(ball))
                    .filter(BallResult::isNotNothing)
                    .findFirst()
                    .orElse(BallResult.NOTHING);

            gameResult.plusScore(ballResult);
        }

        return gameResult;
    }


}
