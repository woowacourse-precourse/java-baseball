package io;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashSet;

public class KeyboardInput {

    private static int inputSize;
    private static final int PLAYING_MODE = 1;
    private static final int PLAY_AGAIN_MODE = 2;

    public KeyboardInput(int inputSize) {
        KeyboardInput.inputSize = inputSize;
    }

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
        if (input.length() != inputSize) {
            throw new IllegalArgumentException("input length is not three.");
        }
    }

    private static void checkInputIsNumNonZero(String input) {
        for (int i = 0; i < inputSize; i++) {
            if (!(input.charAt(i) >= '1' && input.charAt(i) <= '9')) {
                throw new IllegalArgumentException("input contains which is not number.");
            }
        }
    }

    private static void checkInputDuplicated(String input) {
        HashSet<Character> setOfInput = new HashSet<>();
        for (int i = 0; i < inputSize; i++) {
            if (setOfInput.contains(input.charAt(i))) {
                throw new IllegalArgumentException("input contains duplicated input.");
            }
            setOfInput.add(input.charAt(i));
        }
    }

    public static String inputValueTestByMode(String testInput, Integer mode) {
        return validateInput(mode, testInput);
    }
}