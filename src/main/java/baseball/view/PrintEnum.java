package baseball.view;

public enum PrintEnum {

    GAMESTART("숫자 야구 게임을 시작합니다."),
    INPUTNUMBER("숫자를 입력해주세요 : ");

    private final String message;

    PrintEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
