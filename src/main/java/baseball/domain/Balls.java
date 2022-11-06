package baseball.domain;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Balls {
    private List<Ball> balls;

    public Balls(List<Integer> ballNumbers) {
        validateSize(ballNumbers);
        validateUnique(ballNumbers);
        balls = ballNumbers.stream()
                .map(Ball::new)
                .collect(Collectors.toList());
    }


    public boolean hasSameValue(Ball otherBall) {
        if (balls.contains(otherBall)) {
            return true;
        }
        return false;
    }

    public boolean hasSamePosition(Balls otherBalls, Ball ball) {
        return positionOf(ball).equals(otherBalls.positionOf(ball));
    }

    private Optional<Integer> positionOf(Ball ball) {
        Optional<Integer> returnValue = Optional.empty();
        for (int i=0; i<3; i++) {
            if (ball.equals(balls.get(i))) {
                returnValue = Optional.of(i);
            }
        }
        return returnValue;
    }

    private void validateUnique(List<Integer> ballNumbers) {
        if (ballNumbers.size() != ballNumbers.stream().distinct().count()) {
            throw new IllegalArgumentException("서로 다른 값을 입력해주세요.");
        }

    }
    private void validateSize(List<Integer> ballNumbers) {
        if (ballNumbers.size() != 3) {
            throw new IllegalArgumentException("3개의 숫자를 입력해주세요.");
        }
    }
    public Ball ballOf(int index) {
        return balls.get(index);
    }
}
