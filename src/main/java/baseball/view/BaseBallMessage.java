package baseball.view;

public enum BaseBallMessage {

    WELCOME("숫자 야구 게임을 시작합니다."),
    ANSWER_INPUT("숫자를 입력해주세요 : "),
    GAME_END("게임 종료을 종료하겠습니다."),
    PROGRESS_END("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    RESTART_INPUT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");

    private String message;

    BaseBallMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
