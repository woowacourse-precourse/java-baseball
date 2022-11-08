package baseball.message;

public enum GameMessage implements Message {
    WIN_GAME("3개의 숫자를 모두 맞히셨습니다! 게임 종료" + "\n" + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요."),
    BALL("볼"),
    STRIKE("스트라이크"),
    NOTHING("낫싱");

    private String message;

    GameMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
