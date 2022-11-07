package baseball.exception;

import java.util.HashSet;
import java.util.Set;

public class InputException {
    private static final String INPUT_ERROR_MESSAGE = "[ERROR]: WRONG INPUT";
    private static final String REGEXP_NUMBER = "^[1-9]+$";

    public static void inputArgumentCheck(String input, int numLength) {
        if (!checkLength(input, numLength) || !checkNumber(input) || !checkDuplicate(input)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    public static void inputRestartOrQuit(String input, String restart, String quit) {
        if (!checkRestartOrQuit(input, restart, quit)) {
            throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
        }
    }

    private static boolean checkLength( String input, int numLength) {
        return input.length() == numLength;
    }

    private static boolean checkNumber(String input) {
        return input.matches(REGEXP_NUMBER);
    }

    private static boolean checkDuplicate(String input) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            if (!set.add(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRestartOrQuit(String input, String restart, String quit) {
        return input.equals(restart) || input.equals(quit);
    }
}