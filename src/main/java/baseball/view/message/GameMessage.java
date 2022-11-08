package baseball.view.message;

public enum GameMessage {

    START("숫자 야구 게임을 시작합니다."),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    PUSH_NUMBER("숫자를 입력하세요 : "),
    NOTHING("낫싱");

    private final String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
