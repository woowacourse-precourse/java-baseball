package baseball.view;

public enum MessagesForPrint {

    GAMESTART("숫자 야구 게임을 시작합니다."),
    INPUTNUMBER("숫자를 입력해주세요 : "),
    RESULT_BALL("볼"),
    RESULT_STRIKE("스트라이크"),
    RESULT_NOTHING("낫싱");
    private final String message;

    MessagesForPrint(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
