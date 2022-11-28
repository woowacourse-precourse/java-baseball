package baseball.util.message;

public enum ExceptionMessage {

    WRONG_NUMBER_VALUE_ERROR("1에서 9까지의 숫자여야 합니다."),
    WRONG_NUMBER_INDEX_ERROR("0부터 2까지의 인덱스여야 합니다."),
    DUPLICATE_NUMBER_ERROR("중복된 숫자는 컬렉션에 저장할 수 없습니다."),
    WRONG_GAME_RESULT_ERROR("존재할 수 없는 결과입니다."),
    READ_INVALID_PLAYER_NUMBER_ERROR("1에서 9까지 서로 다른 임의의 수 3가지를 입력해야 합니다."),
    READ_INVALID_GAME_COMMAND_ERROR("[1(재시작), 2(종료) 중 하나를 입력해야 합니다.");
    private final String message;

    ExceptionMessage(String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
