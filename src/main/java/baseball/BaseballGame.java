package baseball;

public class BaseballGame {

    private final Baseball baseball;

    public BaseballGame(Baseball baseball) {
        this.baseball = baseball;
    }

    void startNewGame() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        int targetNumber = baseball.createTargetNumber();
    }
}
