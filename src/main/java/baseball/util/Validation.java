package baseball.util;

public class Validation {
    public static void validateInput(String inputString) {
        try {
            Integer.parseInt(inputString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해주세요.");
        }

        if (inputString.length() != 3) {
            throw new IllegalArgumentException("숫자 3자리를 입력해주세요.");
        }

        if (inputString.charAt(0) == inputString.charAt(1)
                || inputString.charAt(0) == inputString.charAt(2)
                || inputString.charAt(1) == inputString.charAt(2)) {
            throw new IllegalArgumentException("서로 다른 숫자 3자리를 입력해주세요.");
        }
    }

    public static void validateReplayInput(String inputString) {
        if (!(inputString.equals("1") || inputString.equals("2"))) {
            throw new IllegalArgumentException("1 또는 2를 입력해주세요.");
        }
    }
}
