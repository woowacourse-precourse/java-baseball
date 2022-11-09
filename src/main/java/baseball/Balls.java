package baseball;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private static final int NUMBER_OF_BALLS = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateBallLength(balls);
        validateNumberDuplication(balls);
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    public int getStrikeCount(Balls otherBalls) {
        return (int) balls.stream()
                .filter(ball -> ball.getResult(otherBalls).equals(BaseballJudge.STRIKE))
                .count();
    }

    public int getBallCount(Balls otherBalls) {
        return (int) balls.stream()
                .filter(ball -> ball.getResult(otherBalls).equals(BaseballJudge.BALL))
                .count();
    }

    private void validateBallLength(List<Ball> balls) {
        if (balls.size() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + BaseballMessage.INVALID_NUMBER_LENGTH_MESSAGE.getMessage());
        }
    }

    private void validateNumberDuplication(List<Ball> balls) {
        if (IntStream.range(0, 10)
                .anyMatch(digit -> getDigitCount(balls, digit) >= 2)) {
            throw new IllegalArgumentException(BaseballMessage.DUPLICATED_NUMBER_MESSAGE.getMessage());
        }
    }

    private long getDigitCount(List<Ball> balls, int digit) {
        return balls.stream()
                .filter(ball -> ball.getNumber() == digit)
                .count();
    }
}
