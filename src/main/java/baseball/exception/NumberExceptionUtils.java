package baseball.exception;

public class NumberExceptionUtils {

    public static void isNotDuplicateNumber(String num) {
        if (num.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("input can't have duplicate number.");
        }
    }

    public static void isThreeDigits(String num) {
        if (num.length() != 3) {
            throw new IllegalArgumentException("input must be three digits.");
        }
    }

    public static void isPositiveDigits(String num) {
        if (Integer.parseInt(num) < 0) {
            throw new IllegalArgumentException("input must be positive digits.");
        }
    }
}
