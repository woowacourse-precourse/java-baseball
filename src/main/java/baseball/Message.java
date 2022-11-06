package baseball;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER("숫자를 입력해주세요 : ");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public void print() {
        System.out.println(message);
    }
}
