package baseball;

public enum Rendering {

    START("숫자 야구 게임을 시작합니다."),
    PUT("숫자를 입력해주세요 : "),
    HINT_BOTH("%d볼 %d스트라이크"),
    HINT_BALL("%d볼"),
    HINT_STRIKE("%d스트라이크"),
    VICTORY("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    CHOOSE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String printLine;

    Rendering(String printLine) {
        this.printLine = printLine;
    }

    public String print() {
        return printLine;
    }
}
