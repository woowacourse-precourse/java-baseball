package baseball;

public enum ResponseMsg {
    GAME_INIT_MSG("숫자 야구 게임을 시작합니다."),
    NUMBER_INPUT_MSG("숫자를 입력해주세요 : "),
    GAME_COMPLETE_MSG("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART_OR_STOP_MSG("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),

    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),

    NUMBER_INPUT_ERROR_MSG("잘못된 입력값 입니다. 중복되지 않는 3자리의 정수를 입력해주세요"),
    GAME_RESTART_OR_STOP_ERROR_MSG("잘못된 입력값 입니다. 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String msg;

    ResponseMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
