package baseball;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Balls {
    private static final int NUMBER_OF_BALLS = 3;

    private List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateBallLength(balls);
        validateNumberRange(balls);
        validateNumberDuplication(balls);
        this.balls = balls;
    }

    public List<Ball> getBalls() {
        return Collections.unmodifiableList(balls);
    }

    private void validateBallLength(List<Ball> balls) {
        if (balls.size() != NUMBER_OF_BALLS) {
            throw new IllegalArgumentException(NUMBER_OF_BALLS + BaseballMessage.INVALID_NUMBER_LENGTH_MESSAGE.getMessage());
        }
    }

    private void validateNumberRange(List<Ball> balls) {
        if (balls.stream()
                .anyMatch(ball -> ball.getNumber() > 9 || ball.getNumber() < 1)) {
            throw new IllegalArgumentException(BaseballMessage.INVALID_NUMBER_RANGE_MESSAGE.getMessage());
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
