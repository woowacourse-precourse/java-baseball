package baseball.exception;

public enum ExceptionCode {

    NUMBER_LENGTH_IS_NOT_CORRECT("입력값은 3자리여야 합니다."),
    NUMBER_ERROR("서로 다른 3자리의 숫자를 입력해야 합니다."),
    RESTART_OR_END("1 또는 2를 입력");

    public final String message;

    ExceptionCode(String message) {
        this.message = message;
    }
}
