package ui;

public enum Messages {

    START_GAME("숫자 야구 게임을 시작합니다.\n"),
    REQUEST_NUMBER_INPUT("숫자를 입력해주세요 : "),
    END_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"),
    REQUEST_RESTART_GAME_INPUT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");

    private final String message;
    Messages(String message) {
        this.message = message;
    }
    public String message() {
        return message;
    }
}
