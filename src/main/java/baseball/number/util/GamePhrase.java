package baseball.number.util;

public enum GamePhrase {

    START_MESSAGE("숫자 야구게임을 시작합니다."),

    RESTART("1"),
    EXIT("2"),

    ERROR_MESSAGE_LENGTH_THREE("세자리 숫자만 입력 가능합니다."),
    ERROR_MESSAGE_NUMBER_RANGE_ONE_TO_NINE("각 자릿수는 1-9 사이의 숫자만 입력 가능합니다."),
    ERROR_MESSAGE_NOT_DUPLICATE("중복된 숫자를 입력할 수 없습니다."),
    BALL_HINT_MESSAGE("볼 "),
    STRIKE_HINT_MESSAGE("스트라이크"),
    NOTHING_HINT_MESSAGE("낫싱"),
    VICTORY_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임종료"),
    RESTART_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    INVALID_QUIT_NUMBER_MESSAGE("1 또는 2를 입력해주세요"),
    QUIT_MESSAGE("게임 종료.");

    private String value;

    private GamePhrase(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
