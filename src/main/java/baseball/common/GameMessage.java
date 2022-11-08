package baseball.common;

public enum GameMessage {
    START_GAME("숫자 야구 게임을 시작합니다."),
    QUESTION__NUMBER("숫자를 입력해주세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTING("낫싱"),

    GAME_OVER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    QUESTION_CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    EXCEPTION_NOT_INPUT3("입력한 수의 갯수가 옳지 않습니다."),
    EXCEPTION_SAME_INPUT("중복된 수가 존재합니다."),
    EXCEPTION_NOT_SCOPE_INPUT("수의 범위가 알맞지 않습니다."),
    EXCEPTION_NOT_RESTART_INPUT("1 혹은 2를 입력해야합니다.");

    private final String value;

    GameMessage(String value) {
        this.value = value;
    }

    public String getName() {
        return name();
    }

    public String getValue() {
        return value;
    }
}
