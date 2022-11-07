package baseball.view;

public class ResultView {
    public void printBall(int ball) {
        System.out.print(ball + "볼");
    }

    public void printStrike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public void success() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
