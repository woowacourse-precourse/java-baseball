package baseball.util;

public enum MessageConstant {

    START_GAME_MESSAGE("숫자 야구 게임을 시작합니다."),
    INPUT_NUMBER_MESSAGE("숫자를 입력해주세요 : "),
    GAME_FINISH_MESSAGE("%s개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    REPLAY_GAME_MESSAGE("게임을 새로 시작하려면 %s, 종료하려면 %s를 입력하세요."),
    STRIKE("스트라이크"),
    BALL("볼"),
    NOTHING("낫싱");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
