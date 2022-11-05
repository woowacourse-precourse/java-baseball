package baseball.utils;

import baseball.Ball;

import java.util.List;

public final class Validator {
    private Validator() {}
    public static final String INVALID_INPUT_VALUE_MESSAGE = "입력값은 서로 다른 1부터 9사이의 숫자로 이루어져야 합니다.";

    public static void validateParseStringToInt(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
        }
    }

    public static void validateInputLength(String playerInput) {
        if (playerInput.length() == 3) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
    }


    public static void validateDuplication(List<Ball> playerBalls, Ball ball) {
        if (playerBalls.contains(ball)) {
            throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
        }
    }

    public static void validateBallNumberRange(Ball ball) {
        if (ball.isValidRange()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_INPUT_VALUE_MESSAGE);
    }
}
