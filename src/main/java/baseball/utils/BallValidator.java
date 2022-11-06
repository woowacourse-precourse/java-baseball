package baseball.utils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BallValidator {

    public static final int MAX_BALL_SIZE = 3;
    public static final String KEEP_PLAY_GAME_CODE = "1";
    private static final String STOP_PLAY_GAME_CODE = "2";
    private static final String ERROR_MESSAGE_NOT_VALID_INPUT_SIZE = "입력 숫자는 총 3개여야 합니다.";
    private static final String ERROR_MESSAGE_DUPLICATE_NUMBER = "입력 숫자 중 중복된 숫자는 존재할 수 없습니다.";
    private static final String ERROR_MESSAGE_NOT_DIGIT = "입력은 숫자만 허용합니다.";
    private static final String ERROR_MESSAGE_NOT_VALID_NUMBER_RANGE = "입력은 1 ~ 9 사이의 수만 허용합니다.";
    private static final String ERROR_MESSAGE_NOT_VALID_GAME_CODE = "재시작/종료 코드는 1 혹은 2입니다.";

    public static void isValidBalls(List<Integer> balls) {
        isValidInputSize(balls.size());
        hasDuplicateNumber(balls);
    }

    public static void isValidBallNo(char ballNo) {
        isDigit(ballNo);
        isNotZero(ballNo);
    }

    private static void isValidInputSize(int inputSize) {
        if (inputSize != MAX_BALL_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_INPUT_SIZE);
        }
    }

    private static void hasDuplicateNumber(List<Integer> balls) {
        Set<Integer> duplicateChecker = new HashSet<>(balls);
        if (duplicateChecker.size() != MAX_BALL_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_DUPLICATE_NUMBER);
        }
    }

    private static void isDigit(char ballNo) {
        if (!Character.isDigit(ballNo)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_DIGIT);
        }
    }

    private static void isNotZero(char ballNo) {
        if (ballNo == 48) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_NUMBER_RANGE);
        }
    }

    public static void isValidGameCode(String gameCode) {
        if (!gameCode.equals(KEEP_PLAY_GAME_CODE) && !gameCode.equals(STOP_PLAY_GAME_CODE)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_VALID_GAME_CODE);
        }
    }
}
