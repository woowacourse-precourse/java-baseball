package baseball;

import java.util.HashSet;
import java.util.Set;

public class NumberValidator {
    private static final int NUMBER_COUNT = 3;
    private static final String GAME_REPLAY = "1";
    private static final String GAME_TERMINATE = "2";
    private static final char ZERO = '0';

    public static void checkInput(String userInput) {
        isNotThreeDigits(userInput);
        isDuplicated(userInput);
        isNotNumber(userInput);
        containsZeroes(userInput);
    }

    public static void checkReplayInput(String replayInput) {
        isNotNumber(replayInput);
        isOneOrTwo(replayInput);
    }

    private static void isNotThreeDigits(String userInput) {
        if (userInput.length() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void isDuplicated(String userInput) {
        Set<Character> duplicateCheck = new HashSet<>();

        for (int index = 0; index < userInput.length(); index++) {
            duplicateCheck.add(userInput.charAt(index));
        }

        if (duplicateCheck.size() != NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }

    private static void isNotNumber(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            char number = userInput.charAt(index);

            if (!Character.isDigit(number)) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void containsZeroes(String userInput) {
        for (int index = 0; index < userInput.length(); index++) {
            char number = userInput.charAt(index);

            if (number == ZERO) {
                throw new IllegalArgumentException();
            }
        }
    }

    private static void isOneOrTwo(String userInput) {
        if (!userInput.equals(GAME_REPLAY) && !userInput.equals(GAME_TERMINATE)) {
            throw new IllegalArgumentException();
        }
    }
}
