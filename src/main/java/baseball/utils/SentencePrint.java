package baseball.utils;

public class SentencePrint {
    public static void print(String message) {
        System.out.print(message);
    }

    public static void println(String message) {
        System.out.println(message);
    }

    public static void printf(String message, int count) {
        System.out.printf(message, count);
    }

    public static void printf(String message, int ball, int strike) {
        System.out.printf(message, ball, strike);
    }

    public static void cause(String message) {
        throw new IllegalArgumentException(message);
    }
}
