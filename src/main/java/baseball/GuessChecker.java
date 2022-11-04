package baseball;

public class GuessChecker {

    private static final int INPUT_LENGTH = 3;

    private GuessChecker() {
    }

    public static void check(String input) {
        checkLength(input);
    }

    private static void checkLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
        }
    }
}
