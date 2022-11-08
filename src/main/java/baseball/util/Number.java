package baseball.util;

public class Number {
    public static final int ZERO = 0;
    public static final int PRESCRIBED_DIGITS = 3;
    public static final int MIN_PICK = 1;
    public static final int MAX_PICK = 9;

    public static boolean isPositive(int ball) {
        return ZERO < ball;
    }
}
