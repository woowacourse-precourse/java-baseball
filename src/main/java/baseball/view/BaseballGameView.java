package baseball.view;

public class BaseballGameView {

    public void printStartGame() {
        System.out.print("숫자 야구 게임을 시작합니다.");
    }

    public void printStrikeCount(int strikeCount) {
        if (strikeCount != 0) {
            System.out.printf("%d스트라이크", strikeCount);
        }
    }
}
