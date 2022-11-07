package baseball;

public enum BaseballMessage {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    REPLAY_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_OVER_MESSAGE("개의 숫자를 모두 맞히셨습니다! 게임 종료"),

    BALL_COUNT_MESSAGE("볼 "),
    STRIKE_COUNT_MESSAGE("스트라이크"),
    NOTHING_MESSAGE("낫싱"),

    INVALID_NUMBER_LENGTH_MESSAGE("자리 숫자만 입력 가능합니다."),
    INVALID_NUMBER_RANGE_MESSAGE("1과 9사이의 숫자만 입력 가능합니다."),
    DUPLICATED_NUMBER_MESSAGE("중복된 숫자가 있습니다.");

    private String message;

    BaseballMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
