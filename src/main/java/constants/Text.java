package constants;

public enum Text {
    NOTIFY_START("숫자 야구 게임을 시작합니다."),
    NUMBER_INPUT_REQUEST("숫자를 입력해주세요 : "),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTING("낫싱"),
    NOTIFY_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    RESTART("1"),
    END("2");

    private final String value;

    Text(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }
}
