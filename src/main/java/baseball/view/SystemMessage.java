package baseball.view;

public enum SystemMessage {
    GAME_START("숫자 야구 게임을 시작합니다."),
    ASK_FOR_INPUT("숫자를 입력해주세요 : "),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱"),
    SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_STOP("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    INPUT_IS_NOT_A_NUMBER("숫자만을 입력해주세요."),
    INPUT_LENGTH_IS_NOT_THREE("입력값의 길이가 잘못되었습니다."),
    INPUT_NUMBER_IS_NOT_UNIQUE("입력값에 중복된 숫자가 있습니다."),
    INPUT_IS_NOT_START_OR_STOP("시작이나 종료의 입력값이 아닙니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
