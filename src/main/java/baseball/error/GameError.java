package baseball.error;

public enum GameError implements Error {

    OVER_MAX_LENGTH("세 자리 숫자를 입력하세요"),
    CONTAINS_NON_NUMBER("입력이 숫자로만 구성되어야 합니다"),
    NUMBER_DUPLICATED("동일한 숫자를 여러 번 사용할 수 없습니다");

    private String message;

    GameError(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
