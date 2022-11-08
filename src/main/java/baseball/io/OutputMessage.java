package baseball.io;

public enum OutputMessage {
    START_MESSAGE("숫자 야구 게임을 시작합니다.\n"),
    INPUT_MESSAGE("숫자를 입력해주세요 : "),
    ENDGAME_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    ENDORRE_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    NOTHING_MESSAGE("낫싱"),
    BALL_MESSAGE("볼"),
    BALL_SPACE_MESSAGE("볼 "),
    STRIKE_MESSAGE("스트라이크");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
