package baseball;

public class Validator {

    public static final String LENGTH_EXCEPTION = "3자리 숫자를 입력해야 합니다.";

    public static void validatePlayerInputNumbersString(String input) {
        validateLength(input);
    }

    public static void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException()
        }
    }
}
