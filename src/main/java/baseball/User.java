package baseball;

import camp.nextstep.edu.missionutils.Console;

public class User {

    private static final int PLAYINGMODE = 1;
    private static final int PLAYAGAINMODE = 2;
    private static final int CORRECTINPUTLENGTH = 3;
    private static String input;

    public static String inputValue(int whatMode) {
        input = Console.readLine();
        return (validateInput(whatMode));
    }

    private static String validateInput(int whatMode) {
        if ((whatMode == PLAYAGAINMODE) && !(input.equals("1") == true || input.equals("2") == true)) {
            throw new IllegalArgumentException("input value is not 1 or 2.");
        }
        if (whatMode == PLAYINGMODE) {
            checkInputLength();
            checkInputIsNumNonZero();
            checkInputDuplicated();
        }
        return (input);
    }

    private static void checkInputLength() {
        if (input.length() != CORRECTINPUTLENGTH) {
            throw new IllegalArgumentException("input length is not three.");
        }
    }

    private static void checkInputIsNumNonZero() {
        for (int i = 0; i < CORRECTINPUTLENGTH; i++) {
            if (!(input.charAt(i) >= '1' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException("input contains which is not number.");
            }
        }
    }

    private static void checkInputDuplicated() {
        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(
            2)) {
            throw new IllegalArgumentException("input contains duplicated input.");
        }
    }

    public static String inputValueTestPlayingMode(String testInput) {
        input = testInput;
        return (validateInput(PLAYINGMODE));
    }

    public static String inputValueTestPlayAgainMode(String testInput) {
        input = testInput;
        return (validateInput(PLAYAGAINMODE));
    }
}