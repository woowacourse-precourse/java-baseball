package baseball.model;

import java.util.*;

public class Balls {
    private static final int START_INDEX = 0;
    private static final int MAX_BALLS_SIZE = 3;
    private static final String DUPLICATED_INPUT_NUMBER_MESSAGE = "입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.";
    private static final String INVALID_INPUT_SIZE_MESSAGE = "입력된 숫자의 값이 " + MAX_BALLS_SIZE + "개가 아닙니다.";
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validateDuplicate(balls);
        validateSize(balls);
        this.balls = balls;
    }

    public Balls() {
        balls = new ArrayList<>();
    }

    private void validateDuplicate(List<Ball> values) {
        Set<Ball> set = new HashSet<>(values);
        if (set.size() != values.size()) {
            throw new IllegalArgumentException(DUPLICATED_INPUT_NUMBER_MESSAGE);
        }
    }

    private void validateSize(List<Ball> values) {
        if (values.size() == MAX_BALLS_SIZE) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT_SIZE_MESSAGE);
    }

    public Result generateResult(Balls compareBalls) {
        Result result = new Result();

        List<Ball> compareValues = compareBalls.getBalls();

        for (int i = START_INDEX; i < MAX_BALLS_SIZE; i++) {
            if (Objects.equals(balls.get(i), compareValues.get(i))) {
                result.increaseStrikeCount();
                continue;
            }
            if (balls.contains(compareValues.get(i))) {
                result.increaseBallCount();
            }
        }
        return result;
    }

    public void addBall(Ball ball) {
        if (balls.contains(ball)) {
            return;
        }
        balls.add(ball);
        validateDuplicate(balls);
    }

    public boolean isSize(int size) {
        return balls.size() == size;
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
