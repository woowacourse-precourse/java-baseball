package baseball.view;

import baseball.constant.Constant;

public enum PrintMessages {
    START("게임을 시작합니다.\n"),
    INPUT("숫자를 입력하세요. : "),
    ANSWER("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    RESTART_OR_END("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n"),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private final String message;
    PrintMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public String getMessageForIntegerFormatting() {
        return Constant.INTEGER_FORMAT_SPECIFIER + message;
    }
}
