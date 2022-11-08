package IOController;

import camp.nextstep.edu.missionutils.Console;

public class KeyboardInput {

    private static int inputSize;
    private static final int PLAYING_MODE = 1;
    private static final int PLAY_AGAIN_MODE = 2;
    private static final int CORRECT_INPUT_LENGTH = 3;

    public KeyboardInput(int inputSize) {
        KeyboardInput.inputSize = inputSize;
    }
//inputsize만 넣고 아직은
    public static String inputValue(int whatMode) {
        return (validateInput(whatMode, Console.readLine()));
    }

    private static String validateInput(int whatMode, String input) {
        if ((whatMode == PLAY_AGAIN_MODE) && !(input.equals("1") || input.equals("2"))) {
            throw new IllegalArgumentException("input value is not 1 or 2.");
        }
        if (whatMode == PLAYING_MODE) {
            checkInputLength(input);
            checkInputIsNumNonZero(input);
            checkInputDuplicated(input);
        }
        return (input);
    }

    private static void checkInputLength(String input) {
        if (input.length() != CORRECT_INPUT_LENGTH) {
            throw new IllegalArgumentException("input length is not three.");
        }
    }

    private static void checkInputIsNumNonZero(String input) {
        for (int i = 0; i < CORRECT_INPUT_LENGTH; i++) {
            if (!(input.charAt(i) >= '1' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException("input contains which is not number.");
            }
        }
    }

    private static void checkInputDuplicated(String input) {
        if (input.charAt(0) == input.charAt(1) || input.charAt(1) == input.charAt(2) || input.charAt(0) == input.charAt(
            2)) {
            throw new IllegalArgumentException("input contains duplicated input.");
        }
    }

    public static String inputValueTestByMode(String testInput, Integer mode) {
        return validateInput(mode, testInput);
    }
}