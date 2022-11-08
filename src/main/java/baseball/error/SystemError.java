package baseball.error;

public enum SystemError implements Error {

    NOT_OP_CODE("재시작은 1, 종료는 2를 입력해주세요");

    private String message;

    SystemError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
