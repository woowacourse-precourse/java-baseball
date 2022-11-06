package baseball.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Balls {
    private static final int BALLS_MAX_SIZE = 3;
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;
    private static final String DUPLICATED_INPUT_NUMBER_MESSAGE = "입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.";

    private static final String INVALID_INPUT_SIZE_MESSAGE = "입력된 숫자의 값이 " + BALLS_MAX_SIZE + "개가 아닙니다.";
    private static final String INVALID_INPUT_RANGE_MESSAGE = "입력된 숫자의 값은 " + MIN_BALL_NUMBER + "부터 " + MAX_BALL_NUMBER + "사이의 값이어야 합니다.";
    private final List<Integer> balls;

    public Balls(List<Integer> balls) {
        validateDuplicate(balls);
        validateSize(balls);
        validateNumberRange(balls);
        this.balls = balls;
    }

    private void validateDuplicate(List<Integer> balls) {
        Set<Integer> set = new HashSet<>(balls);
        if (set.size() != balls.size()) {
            throw new IllegalArgumentException(DUPLICATED_INPUT_NUMBER_MESSAGE);
        }
    }

    private void validateSize(List<Integer> balls) {
        if (balls.size() == BALLS_MAX_SIZE) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT_SIZE_MESSAGE);
    }

    private void validateNumberRange(List<Integer> balls) {
        for (int ball : balls) {
            if (ball < MIN_BALL_NUMBER || ball > MAX_BALL_NUMBER) {
                throw new IllegalArgumentException(INVALID_INPUT_RANGE_MESSAGE);
            }
        }
    }

    public void addBall(int number) {
        if (balls.contains(number)) {
            return;
        }
        balls.add(number);
        validateDuplicate(balls);
    }

    public boolean isSize(int size) {
        return balls.size() == size;
    }
}
