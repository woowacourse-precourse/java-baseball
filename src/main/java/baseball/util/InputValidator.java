package baseball.util;

import java.util.HashSet;
import java.util.Set;
import java.util.regex.Pattern;

import static baseball.model.BaseBall.MAX_BASEBALL_SIZE;

public class InputValidator {
    private static final String CANNOT_INPUT_DUPLICATE_NUMBER = "중복된 값을 입력할 수 없습니다.";
    private static final String INPUT_THREE_NUMBERS = "3자리의 숫자를 입력해주세요.";
    private static final String CANNOT_INPUT_ZERO = "숫자 0은 입력할 수 없습니다.";
    public static final char ZERO = '0';
    public static final String NUMBER_REGEX = "^[0-9]+$";
    public static final String CANNOT_INPUT_EXCEPT_NUMBER = "입력은 숫자 이외의 다른 문자가 포함될 수 없습니다.";

    private static Set<Character> duplicateChecker;

    public static void validate(String input) {
        isAllNumber(input);
        isThreeWords(input);
        hasZero(input);
        checkDuplicateNumber(input);
    }

    private static void isAllNumber(String input) {
        if (isExceptNumber(input)) {
            throw new IllegalArgumentException(CANNOT_INPUT_EXCEPT_NUMBER);
        }
    }

    private static boolean isExceptNumber(String input) {
        return !Pattern.matches(NUMBER_REGEX, input);
    }

    private static void isThreeWords(String input) {
        if (isDifferentLength(input)) {
            throw new IllegalArgumentException(INPUT_THREE_NUMBERS);
        }
    }

    private static boolean isDifferentLength(String input) {
        return input.length() != MAX_BASEBALL_SIZE;
    }

    private static void hasZero(String input) {
        for (int index = 0; index < MAX_BASEBALL_SIZE; index++) {
            ifZeroThrowException(input.charAt(index));
        }
    }

    private static void ifZeroThrowException(char number) {
        if (isZero(number)) {
            throw new IllegalArgumentException(CANNOT_INPUT_ZERO);
        }
    }

    private static boolean isZero(char number) {
        return number == ZERO;
    }

    private static void checkDuplicateNumber(String input) {
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
        if (validate()) {
            throw new IllegalArgumentException(CANNOT_INPUT_DUPLICATE_NUMBER);
        }
    }

    private static boolean validate() {
        return duplicateChecker.size() != MAX_BASEBALL_SIZE;
    }
}
