package baseball;

public enum MessageCode {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"),
    INSERT_NUMBER("숫자를 입력해주세요 : ");

    private final String content;

    MessageCode(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return content;
    }
}