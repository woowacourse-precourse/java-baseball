package custom.printer;

public enum PrintTemplate {
    BEGIN("숫자 야구 게임을 시작합니다."),
    PLZ_INPUT("숫자를 입력해주세요 : "),
    GOOD_JOB("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    IF_RETRY("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    PrintTemplate(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
