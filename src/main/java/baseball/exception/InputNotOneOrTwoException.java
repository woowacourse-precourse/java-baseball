package baseball.exception;

public class InputNotOneOrTwoException extends IllegalArgumentException{
    public InputNotOneOrTwoException() {
        super("1또는 2만 입력하시오.");
    }
}
