package baseball.utils;

import static baseball.Game.EXIT_SIGNAL;
import static baseball.Game.RESTART_SIGNAL;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class InputValidator {

    private static final List<String> STANDARD_NUMBER = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");
    private static final int MAX_SIZE = 3;

    private InputValidator() {
    }

    public static void checkUserBallInput(final String userBallInput) {
        checkBallNumberLength(userBallInput);
        checkDuplicateBalls(checkBallNumberIsValidNumber(userBallInput));
    }

    private static void checkBallNumberLength(final String userBallInput) {
        if (MAX_SIZE != userBallInput.length()) {
            throw new IllegalArgumentException();
        }
    }

    private static List<String> checkBallNumberIsValidNumber(final String userBallInput) {
        List<String> splitUserBall = Arrays.asList(userBallInput.split(""));
        for (String ball : splitUserBall) {
            checkStandardNumber(ball);
        }
        return splitUserBall;
    }

    private static void checkStandardNumber(final String ball) {
        if (!STANDARD_NUMBER.contains(ball)) {
            throw new IllegalArgumentException();
        }
    }

    private static void checkDuplicateBalls(final List<String> balls) {
        if (MAX_SIZE != new HashSet<>(balls).size()) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRestartInput(String restartOrExit) {
        if (!RESTART_SIGNAL.equals(restartOrExit) && !EXIT_SIGNAL.equals(restartOrExit)) {
            throw new IllegalArgumentException();
        }
    }

}
