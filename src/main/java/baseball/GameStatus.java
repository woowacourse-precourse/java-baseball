package baseball;

public enum GameStatus {
    INIT("숫자 야구 게임을 시작합니다."),
    INPUT("숫자를 입력해주세요 : "),
    SUCCESS("3개의 숫자를 모두 맞히셨습니다! 게임 종료"),
    QUIT("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    ERROR_CODE("1 혹은 2를 입력해주세요.");

    private final String message;

    GameStatus(String message) {
        this.message = message;
    }

    public String message() {
        return this.message;
    }
}
