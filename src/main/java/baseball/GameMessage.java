package baseball;

public enum GameMessage {
    START("숫자 야구 게임을 시작합니다."),
    INPUT_VALUE("숫자를 입력해주세요 : "),
    END("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    public String getText() {
        return message;
    }
}
