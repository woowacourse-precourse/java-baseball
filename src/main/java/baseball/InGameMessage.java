package baseball;

public enum InGameMessage {

    BASEBALL_GAME_STARTING_MESSAGE("숫자 야구 게임을 시작합니다."),
    BASEBALL_GAME_EXIT_MESSAGE("게임 종료"),
    BASEBALL_GAME_GET_USER_INPUT_MESSAGE("숫자를 입력하세요."),
    BASEBALL_GAME_RESULT_NOTHING("낫싱"),
    BASEBALL_GAME_RESULT_BALL("%d볼\n"),
    BASEBALL_GAME_RESULT_STRIKE("%d스트라이크\n"),
    BASEBALL_GAME_RESULT_BALL_STRIKE("%d볼 %d스트라이크\n"),
    BASEBALL_GAME_RESTART_CHECK_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BASEBALL_GAME_ASK_FOR_DIVIDED_NUMBER_MESSAGE("※ 서로 다른 숫자 %d개를 입력해주세요. ※\n"),
    BASEBALL_GAME_FORCE_EXIT_MESSAGE("※ %d초 이상 입력이 없어 게임을 자동 종료합니다. ※\n"),;

    private String message;

    private InGameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
