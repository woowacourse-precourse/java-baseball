package baseball.utils;

public class Validator {
    public static void checkUserAnswerInput(String userAnswer) {
        checkStringLength(userAnswer, 3);
    }

    private static void checkStringLength(String string, int length) {
        if(string.length() != length) {
            throw new IllegalArgumentException();
        }
    }
}
