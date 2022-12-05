package baseball;

public enum Rendering {

    START("숫자 야구 게임을 시작합니다."),
    ERROR("[ERROR] 서로 다른 세 자리 수만 입력 가능합니다."),
    PUT("숫자를 입력해주세요 : "),
    BALL_STRIKE("%d볼 %d스트라이크"),
    BALL("%d볼"),
    STRIKE("%d스트라이크"),
    NOTHING("낫싱"),
    VICTORY("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CHOOSE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Rendering(String message) {
        this.message = message;
    }

    public String render() {
        return message;
    }
}
