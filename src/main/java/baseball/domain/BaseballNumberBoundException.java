package baseball.domain;

public class BaseballNumberBoundException extends RuntimeException {

    private static final String MESSAGE = "허용되지 않는 범위의 값입니다.";

    public BaseballNumberBoundException() {
        super(MESSAGE);
    }
}
