package baseball.util;

public enum OutputPharse {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_INFO("숫자를 입력해주세요 : ");

    private final String msg;

    OutputPharse(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }
}
