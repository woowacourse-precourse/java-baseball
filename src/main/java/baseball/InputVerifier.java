package baseball;

import baseball.utils.Util;

public final class InputVerifier {
    public static void verifyInput(String input) {
        try {
            isNumber(input);
            isThreeDigits(input);
            isDistinctDigits(input);
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }

    private static void isNumber(String input) {
        Integer.parseInt(input);
    }

    private static void isThreeDigits(String input) {
        if (input.length() != SystemConstant.GAME_DIGIT) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDistinctDigits(String input) {
        if (Util.hasDuplicatedChar(input)) {
            throw new IllegalArgumentException();
        }
    }
}
