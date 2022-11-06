package baseball;

public class PlayerOutputView {

    public static void printResultMessage(int strike, int ball) {
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        if (ball > 0) {
            System.out.print(ball + "볼");
        }
        if (strike == Compare.CLEAR_NUM) {
            System.out.println();
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
        if (strike == 0 && ball == 0) {
            System.out.println("낫싱");
        }

    }
}
