package baseball.domain;

public enum MESSAGE {
    GAME_START("숫자 야구 게임을 시작합니다."),
    GAME_RESTART("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    READ_NUMBER("3개의 숫자를 입력해주세요 : "),
    GAME_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료");

    private String message;
    MESSAGE(String message) {
        this.message = message;
    }
    public String toString() {
        return message;
    }
}
