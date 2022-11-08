package baseball;

import java.util.regex.Pattern;

public class CheckException {

    public void validateConsistsOfNumber(String input) {
        String pattern = "^[1-9]*$";
        boolean result = Pattern.matches(pattern, input);

        if (!result) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
    }

    public void validateNumberLength(String input) {
        if (input.length() != GameStatus.MAX_SIZE.getValue()) {
            throw new IllegalArgumentException("3개의 숫자만 입력할 수 있습니다.");
        }
    }

    public void validateOverlap(int size) {
        if (size != GameStatus.MAX_SIZE.getValue()) {
            throw new IllegalArgumentException("중복된 숫자가 있으면 안됩니다.");
        }
    }

    public int validateGameStatusData(String input) {
        try {
            int result = Integer.parseInt(input);
            if (result != GameStatus.RESTART.getValue() && result != GameStatus.EXIT.getValue()) {
                throw new RuntimeException();
            }
            return result;
        } catch (Exception e) {
            throw new IllegalArgumentException("0 또는 1을 입력해야 합니다.");
        }
    }
}
