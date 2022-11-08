package baseball;

import java.util.regex.Pattern;

public class CheckException {
    private static final int MAX_SIZE = 3;
    public static final int RESTART = 1;
    public static final int EXIT = 2;
    public void validateConsistsOfNumber(String input) {
        String pattern = "^[0-9]*$";
        boolean result = Pattern.matches(pattern, input);

        if (!result) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public void validateNumberLength(String input) {
        if (input.length() != MAX_SIZE) {
            throw new IllegalArgumentException("3개의 숫자만 입력할 수 있습니다.");
        }
    }

    public void validateOverlap(int size) {
        if (size != MAX_SIZE) {
            throw new IllegalArgumentException("중복된 숫자가 있으면 안됩니다.");
        }
    }

    public int validateGameStatusData(String input) {
        try {
            int result = Integer.parseInt(input);
            if (result != RESTART && result != EXIT) {
                throw new RuntimeException();
            }
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("0 또는 1을 입력해야 합니다.");
        }
    }
}
