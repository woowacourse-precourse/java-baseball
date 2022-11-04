package baseball.exception;

public class NumberExceptionUtils {

    public static void isNotDuplicateNumber(String num) {
        if (num.chars().distinct().count() != 3) {
            throw new IllegalArgumentException("input can't have duplicate number.");
        }
    }
}
