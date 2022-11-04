package baseball.Message;

public enum PlayMessage {
    INPUT_NUMBERS("숫자를 입력해주세요 : "),
    GAME_START("숫자 야구 게임을 시작합니다."),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱"),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    WHETHER_TO_CONTINUE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    private PlayMessage(final String message) {
        this.message = message;
    }

    public String toMessage() {
        return message;
    }
}
