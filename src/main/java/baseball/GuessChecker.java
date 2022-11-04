package baseball;

public class GuessChecker {

    private static final int INPUT_LENGTH = 3;

    private GuessChecker() {
    }

    public static void check(String input) {
        checkLength(input);
        checkIsNumeric(input);
    }

    private static void checkLength(String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
        }
    }

    private static void checkIsNumeric(String input) {
        for (int position = 0; position < input.length(); position++) {
            char character = input.charAt(position);
            if (!isNumeric(character)) {
                throw new IllegalArgumentException("숫자가 아닌 문자는 들어올 수 없습니다.");
            }
        }
    }

    private static boolean isNumeric(char c) {
        return c >= '0' && c <= '9';
    }
}
