package baseball.global.exception;

public enum CustomException {

    NUMBER_OUT_OF_RANGE("1부터 9까지의 숫자만 입력이 가능합니다."),
    INVALID_DATA_TYPE("숫자만 입력이 가능합니다."),
    INVALID_THREE_DIGIT("서로 다른 3자리의 수를 입력해주세요."),
    INVALID_GAME_FLAG("숫자 1또는 2를 입력해주세요.")
    ;

    private final String message;

    CustomException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
