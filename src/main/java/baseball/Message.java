package baseball;

public enum Message {
    GAME_START_MESSAGE("숫자 야구 게임을 시작합니다."),
    CORRECT_ANSWER_MESSAGE("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    NOTHING_MESSAGE("낫싱"),
    RECEIVE_THREE_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    RECEIVE_ONE_NUMBER_MESSAGE("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
