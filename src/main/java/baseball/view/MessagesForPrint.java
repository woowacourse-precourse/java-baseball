package baseball.view;

public enum MessagesForPrint {

    GAMESTART("숫자 야구 게임을 시작합니다."),
    INPUTNUMBER("숫자를 입력해주세요 : "),
    RESULT_BALL("볼"),
    RESULT_STRIKE("스트라이크"),
    RESULT_NOTHING("낫싱"),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    private final String message;

    MessagesForPrint(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
