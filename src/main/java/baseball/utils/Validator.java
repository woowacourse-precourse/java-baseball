package baseball.utils;

import baseball.Ball;
import baseball.GameStatus;

import java.util.List;

public final class Validator {
    private Validator() {}
    public static final String INVALID_BALL_INPUT_VALUE_MESSAGE = "사용자의 공 입력값은 서로 다른 1부터 9사이의 숫자로 이루어져야 합니다.";
    public static final String INVALID_GAME_STATUS_INPUT_VALUE_MESSAGE = "게임 상태는 재시작:1, 종료:2 중에서 입력해야 합니다";
    public static void validateParseStringToInt(String playerInput) {
        try {
            Integer.parseInt(playerInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_BALL_INPUT_VALUE_MESSAGE);
        }
    }

    public static void validateInputLength(String playerInput) {
        if (playerInput.length() == 3) {
            return;
        }
        throw new IllegalArgumentException(INVALID_BALL_INPUT_VALUE_MESSAGE);
    }


    public static void validateDuplication(List<Ball> playerBalls, Ball ball) {
        if (playerBalls.contains(ball)) {
            throw new IllegalArgumentException(INVALID_BALL_INPUT_VALUE_MESSAGE);
        }
    }

    public static void validateBallNumberRange(Ball ball) {
        if (ball.isValidRange()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_BALL_INPUT_VALUE_MESSAGE);
    }

    public static void validateGameStatus(GameStatus gameStatus) {
        if (gameStatus.isValid()) {
            return;
        }
        throw new IllegalArgumentException(INVALID_GAME_STATUS_INPUT_VALUE_MESSAGE);
    }
}
