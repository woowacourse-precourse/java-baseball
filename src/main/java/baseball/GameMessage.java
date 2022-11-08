package baseball;

public enum GameMessage {
    START("숫자 야구 게임을 시작합니다."),
    INPUT_VALUE("숫자를 입력해주세요 : ");
    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getText() {
        return message;
    }
}
