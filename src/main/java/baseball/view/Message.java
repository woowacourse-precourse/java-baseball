package baseball.view;

public enum Message {
    START_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_PLAYER_NUM_MESSAGE("숫자를 입력해주세요 : ");

    private final String message;

    Message(String message) {
        this.message=message;
    }
}
