package baseball.service;

public class Validator {

    public static void validInput(String text) {
        if (text.length() != 3) {
            throw new IllegalArgumentException("숫자는 3자리 수이어야 합니다.");
        } else if (!text.matches("^[1-9]+$")) {
            throw new IllegalArgumentException("입력은 숫자로만 이루어져야 합니다.");
        }
    }

    public static void validRestartInput(String text) {
        if (!text.matches("^[1-2]$")) {
            throw new IllegalArgumentException();
        }
    }
}
