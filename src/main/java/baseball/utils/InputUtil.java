package baseball.utils;

public class InputUtil {
    private static final String ISDIGIT_EXCEPTION = "숫자가 아닙니다.";

    public InputUtil(){
    }
    public void checkIsDigit(char number) {
        if (!Character.isDigit(number)) {
            throw new IllegalArgumentException(ISDIGIT_EXCEPTION);
        }
    }
}
