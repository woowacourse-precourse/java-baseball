package baseball.text;

public enum StaticText {
    PROGRAM_START("숫자 야구 게임을 시작합니다."),
    PROGRAM_END("게임 종료"),
    ASK_ANSWER("숫자를 입력해 주세요 : "),
    ASK_RETRY("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요 : "),
;

    private final String message;

    StaticText(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(this.message);
    }
}
