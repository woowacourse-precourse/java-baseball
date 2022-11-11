package baseball;

public enum Message {

    CLOSE_MESSAGE("애플리케이션을 종료합니다."),
    CONGRATULATION_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    GAME_OPTION_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    GAME_OPTION_ERROR_MESSAGE("1 또는 2를 입력하세요."),
    INPUT_USER_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    INPUT_USER_NUMBER_ERROR_MESSAGE("1부터 9까지의 서로 다른 3자리의 양의 정수를 입력하세요.");

    private final String value;

    Message(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
