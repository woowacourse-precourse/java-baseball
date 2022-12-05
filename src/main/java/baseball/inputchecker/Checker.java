package baseball.inputchecker;

import java.util.HashSet;
import java.util.Set;

public class Checker {
    static Set dupChecker;

    public static void isValid(String input) {
        dupChecker = new HashSet<>();
        isNumeric(input);
        isValidLength(input);
        isNotDup(input);
    }

    public static void isNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public static void isValidLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException("세자리 숫자만 입력할 수 있습니다.");
        }
    }

    public static void isNotDup(String input) {
        for (char c : input.toCharArray()) {
            dupChecker.add(c);
        }
        if (dupChecker.size() != 3) {
            throw new IllegalArgumentException("중복되는 숫자를 입력할 수 없습니다");
        }
    }
}
