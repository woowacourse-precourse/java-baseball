package baseball.util;

import java.util.HashSet;
import java.util.Set;

import static baseball.model.User.MAX_INPUT_LENGTH;

public class DuplicateChecker {
    private static final String CANNOT_INPUT_DUPLICATE_NUMBER = "중복된 값을 입력할 수 없습니다.";

    private static Set<Character> duplicateChecker;

    public static void hasSameNumber(String input) {
        addToSet(input);
        ifHasSameNumberThrowException();
    }

    private static void addToSet(String input) {
        duplicateChecker = new HashSet<>();
        for (char number : input.toCharArray()) {
            duplicateChecker.add(number);
        }
    }

    private static void ifHasSameNumberThrowException() {
        if (hasSameNumber()) {
            throw new IllegalArgumentException(CANNOT_INPUT_DUPLICATE_NUMBER);
        }
    }

    private static boolean hasSameNumber() {
        return duplicateChecker.size() != MAX_INPUT_LENGTH;
    }
}
