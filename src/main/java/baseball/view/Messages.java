package baseball.view;

public enum Messages {
    START("게임을 시작합니다.\n"),
    INPUT("숫자를 입력하세요. : "),
    ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱");

    private final String message;
    Messages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
