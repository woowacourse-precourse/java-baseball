package baseball.enums;

public enum Message {
    GAME_START("숫자 야구 게임을 시작합니다."),
    ENTER_NUMBER("숫자를 입력해주세요 : "),
    CORRECT_ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_OR_STOP("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),

    STAND_BY("-1"),
    ONGOING("0"),
    RESTART("1"),
    STOP("2");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String status() {
        return message;
    }
}
