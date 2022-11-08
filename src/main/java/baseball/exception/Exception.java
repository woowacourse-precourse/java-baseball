package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    private static int INPUT_LENGTH = 3;
    private static int INPUT_RESTART_LENGTH = 1;
    private static char INPUT_START = '1';
    private static char INPUT_END = '9';
    private static char GAME_RESTART = '1';
    private static char GAME_END = '2';

    public static void validateInputNumber(String input) {
        validateInputLength(input, INPUT_LENGTH);
        validateIsDuplicate(input);
        validateIsNumeric(input, INPUT_START, INPUT_END);
    }

    public static void validateInputRestart(String input) {
        validateInputLength(input, INPUT_RESTART_LENGTH);
        validateIsNumeric(input, GAME_RESTART, GAME_END);
    }

    private static void validateInputLength(String input, int rightLength) {
        if (input.length() != rightLength) {
            throw new IllegalArgumentException("길이가 " + rightLength + "인 수를 입력해주세요.");
        }
    }

    private static void validateIsDuplicate(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < 3; i++) {
            characterSet.add(input.charAt(i));
        }
        if (characterSet.size() != 3) {
            throw new IllegalArgumentException("중복된 숫자를 입력하지 말아주세요.");
        }
    }

    private static void validateIsNumeric(String input, char startNumber, char endNumber) {
        for (int i = 0; i < 3; i++) {
            checkInterval(input.charAt(i), startNumber, endNumber);
        }
    }

    private static void checkInterval(char input, char startNumber, char endNumber) {
        if (input < startNumber || input > endNumber) {
            throw new IllegalArgumentException(startNumber + "~" + endNumber + "사이의 숫자만 입력해주세요.");
        }
    }

}
