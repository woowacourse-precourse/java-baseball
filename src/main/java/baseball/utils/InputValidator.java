package baseball.utils;

import static baseball.system.Constant.*;

public final class InputValidator {
    public static final String INVALID_LENGTH_EXCEPTION = "띄어쓰기 없이 연속해서 숫자 3개를 입력해주세요.";
    public static final String NOT_NUMBER_EXCEPTION = "1에서 9까지의 숫자 3개를 입력해주세요.";
    public static final String NOT_ONE_OR_TWO_EXCEPTION = "숫자 1또는 2 중에 하나를 입력해주세요.";

    private InputValidator() {

    }

    public static void isLengthThree(String input) {
        if (input.length() != NUMBERS_SIZE) {
            throw new IllegalArgumentException(INVALID_LENGTH_EXCEPTION);
        }
    }

    public static void isAllNumber(String input) {
        for (int i = 0; i < NUMBERS_SIZE; i++) {
            if (!input.matches("[0-9]+")) {
                throw new IllegalArgumentException(NOT_NUMBER_EXCEPTION);
            }
        }
    }

    public static void isOneOrTwo(String input) {
        if (!input.equals(GAME_RESTART) && !input.equals(GAME_QUIT)) {
            throw new IllegalArgumentException(NOT_ONE_OR_TWO_EXCEPTION);
        }
    }
}
