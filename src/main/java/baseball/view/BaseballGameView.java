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

    public void printBallCount(int ballCount) {
        if (ballCount != 0) {
            System.out.printf("%d볼 ", ballCount);
        }
    }

    public void printNotThing(int strikeCount, int ballCount) {
        if (strikeCount == 0 && ballCount == 0) {
            System.out.print("낫싱");
        }
    }

    public void printEndMessage() {
        System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
