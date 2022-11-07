package baseball;

public class PrintBallOrStrike {
    public void ball(int ball) {
        System.out.println(ball + "볼");
    }

    public void strike(int strike) {
        System.out.println(strike + "스트라이크");
    }

    public void threeStrike() {
        System.out.println("3스트라이크" + '\n' + "3개의 숫자를 모두 맞히셨습니다! 게임 종료" + '\n' + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    public void ballAndStrike(int ball, int strike) {
        System.out.println(ball + "볼 " + strike + "스트라이크");
    }
}
