package baseball.exception;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

public class InputException {

    private static final int USER_NUMBER_LENGTH = 3;
    private static final String RESTART_NUMBER = "1";
    private static final String END_NUMBER = "2";

    public static String validUserNumberException(String userNumber) {
        if (isThreeLength(userNumber) || isInteger(userNumber)
                || isIncludeZero(userNumber) || isDuplicationNumber(userNumber)) {
            throw new IllegalArgumentException();
        }
        return userNumber;
    }

    private static boolean isDuplicationNumber(String userNumber) {
        Set<Character> set = new HashSet<>();
        IntStream.range(0, 3)
                .forEach(i -> set.add(userNumber.charAt(i)));
        return USER_NUMBER_LENGTH != set.size();
    }

    private static boolean isIncludeZero(String userNumber) {
        return 0 < (int) IntStream.range(0, 3)
                .filter(i -> userNumber.charAt(i) == '0')
                .count();
    }

    private static boolean isInteger(String userNumber) {
        return 0 < (int) IntStream.range(0, 3)
                .filter(i -> !Character.isDigit(userNumber.charAt(i)))
                .count();
    }

    private static boolean isThreeLength(String userNumber) {
        return userNumber.length() != USER_NUMBER_LENGTH;
    }

    public static String validRestartNumberException(String restartNumber) {
        if (!restartNumber.equals(RESTART_NUMBER) && !restartNumber.equals(END_NUMBER)) {
            throw new IllegalArgumentException();
        }
        return restartNumber;
    }
}
