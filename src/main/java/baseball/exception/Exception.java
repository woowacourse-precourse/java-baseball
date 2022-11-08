package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class Exception {
    private static final int INPUT_LENGTH = 3;
    private static final int INPUT_RESTART_LENGTH = 1;
    private static final char INPUT_START = '1';
    private static final char INPUT_END = '9';
    private static final char GAME_RESTART = '1';
    private static final char GAME_END = '2';

    public static void validateInputNumber(String input) {
        validateInputLength(input, INPUT_LENGTH);
        validateIsDuplicate(input);
        validateIsNumeric(input, INPUT_START, INPUT_END);
    }

    public static void validateInputRestart(String input) {
        validateInputLength(input, INPUT_RESTART_LENGTH);
        validateIsNumeric(input, GAME_RESTART, GAME_END);
    }

    public static void validateInputLength(String input, int rightLength) {
        if (input.length() != rightLength) {
            throw new IllegalArgumentException("길이가 " + rightLength + "인 수를 입력해주세요.");
        }
    }

    public static void validateIsDuplicate(String input) {
        Set<Character> characterSet = new HashSet<>();
        for (int i = 0; i < INPUT_LENGTH; i++) {
            characterSet.add(input.charAt(i));
        }
        if (characterSet.size() != INPUT_LENGTH) {
            throw new IllegalArgumentException("중복된 숫자를 입력하지 말아주세요.");
        }
    }

    public static void validateIsNumeric(String input, char startNumber, char endNumber) {
        for (int i = 0; i < input.length(); i++) {
            checkInterval(input.charAt(i), startNumber, endNumber);
        }
    }

    private static void checkInterval(char input, char startNumber, char endNumber) {
        if (input < startNumber || input > endNumber) {
            throw new IllegalArgumentException(startNumber + "~" + endNumber + "사이의 숫자만 입력해주세요.");
        }
    }

}
