package baseball.checker;

public final class GuessChecker {

    private static final int INPUT_LENGTH = 3;
    private static final char RANGE_START = '1';
    private static final char RANGE_END = '9';

    private GuessChecker() {
    }

    public static void check(final String input) {
        checkLength(input);
        checkRange(input);
        checkDuplicate(input);
    }

    private static void checkLength(final String input) {
        if (input.length() != INPUT_LENGTH) {
            throw new IllegalArgumentException("입력의 길이는 3이어야 합니다.");
        }
    }

    private static void checkRange(final String input) {
        for (int position = 0; position < input.length(); position++) {
            char character = input.charAt(position);
            if (!isValidRange(character)) {
                throw new IllegalArgumentException("1 ~ 9까지의 숫자가 아닌 문자는 들어올 수 없습니다.");
            }
        }
    }

    private static boolean isValidRange(final char c) {
        return c >= RANGE_START && c <= RANGE_END;
    }

    private static void checkDuplicate(final String input) {
        for (int position = 0; position < input.length(); position++) {
            char character = input.charAt(position);
            if (input.lastIndexOf(character) != position) {
                throw new IllegalArgumentException("중복된 숫자는 들어올 수 없습니다.");
            }
        }
    }
}
