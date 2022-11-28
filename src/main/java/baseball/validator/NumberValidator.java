package baseball.validator;

public class NumberValidator {
    private final static String RESTART_ERROR_MESSAGE = "1또는 2를 입력해주세요.";


    public static void validateRestartNumber(int input) {
        if (input == 1) {
            return;
        }
        if (input == 2) {
            return;
        }
        throw new IllegalArgumentException(RESTART_ERROR_MESSAGE);
    }
}
