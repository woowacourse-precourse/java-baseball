package baseball.model.dto;

import java.util.*;

public class Balls {
    private static final int START_INDEX = 0;
    private static final int MAX_BALLS_SIZE = 3;
    private static final int MIN_BALL_NUMBER = 1;
    private static final int MAX_BALL_NUMBER = 9;
    private static final String DUPLICATED_INPUT_NUMBER_MESSAGE = "입력된 숫자의 값에 중복된 값이 포함되어서는 안됩니다.";
    private static final String INVALID_INPUT_SIZE_MESSAGE = "입력된 숫자의 값이 " + MAX_BALLS_SIZE + "개가 아닙니다.";
    private static final String INVALID_INPUT_RANGE_MESSAGE = "입력된 숫자의 값은 " + MIN_BALL_NUMBER + "부터 " + MAX_BALL_NUMBER + "사이의 값이어야 합니다.";
    private final List<Integer> values;

    public Balls(List<Integer> values) {
        validateDuplicate(values);
        validateSize(values);
        validateNumberRange(values);
        this.values = values;
    }

    public Balls() {
        values = new ArrayList<>();
    }

    private void validateDuplicate(List<Integer> values) {
        Set<Integer> set = new HashSet<>(values);
        if (set.size() != values.size()) {
            throw new IllegalArgumentException(DUPLICATED_INPUT_NUMBER_MESSAGE);
        }
    }

    private void validateSize(List<Integer> values) {
        if (values.size() == MAX_BALLS_SIZE) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT_SIZE_MESSAGE);
    }

    private void validateNumberRange(List<Integer> values) {
        for (Integer ball : values) {
            if (ball < MIN_BALL_NUMBER || ball > MAX_BALL_NUMBER) {
                throw new IllegalArgumentException(INVALID_INPUT_RANGE_MESSAGE);
            }
        }
    }

    public Result generateResult(Balls compareBalls) {
        Result result = new Result();

        List<Integer> compareValues = compareBalls.getValues();

        for (int i = START_INDEX; i < MAX_BALLS_SIZE; i++) {
            if (Objects.equals(values.get(i), compareValues.get(i))) {
                result.increaseStrikeCount();
                continue;
            }
            if (values.contains(compareValues.get(i))) {
                result.increaseBallCount();
            }
        }
        return result;
    }

    public void addBall(int number) {
        if (values.contains(number)) {
            return;
        }
        values.add(number);
        validateDuplicate(values);
    }

    public boolean isSize(int size) {
        return values.size() == size;
    }

    public List<Integer> getValues() {
        return values;
    }
}
