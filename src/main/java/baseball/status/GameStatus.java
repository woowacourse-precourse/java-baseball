package baseball.status;

public enum GameStatus {
    RESTART_OR_STOP_GAME("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    START_GAME("숫자 야구 게임을 시작합니다."),
    INPUT_USER_NUMBER("숫자를 입력해주세요 : "),
    END_GAME("게임 종료"),
    SUCCESS_GAME("3개의 숫자를 모두 맞추셨습니다! 게임 종료");

    private final String text;
    GameStatus(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
