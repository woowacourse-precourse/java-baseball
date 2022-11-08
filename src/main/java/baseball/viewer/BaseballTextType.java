package baseball.viewer;

public enum BaseballTextType {
    WELCOME_MESSAGE("\n숫자 야구 게임을 시작합니다."),
    REQUEST_INPUT("\n숫자를 입력해주세요 : "),
    WINNER("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RETRY_OR_QUIT("\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String text;

    BaseballTextType(String text) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }
}
