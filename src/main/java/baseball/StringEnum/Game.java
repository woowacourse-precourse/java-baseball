package baseball.StringEnum;

public enum Game {
    START("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    END("%d개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART("게임을 새로 시작하려면 %d, 종료하려면 %d를 입력하세요.");

    private final String content;

    Game(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
