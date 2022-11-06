package baseball.view;

public enum PrintEnum {

    GameStart("숫자 야구 게임을 시작합니다.");

    private final String message;

    PrintEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
