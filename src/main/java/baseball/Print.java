package baseball;

public class Print {
    static void nothing() {
        System.out.print("낫싱");
    }

    static void threeStrike() {
        System.out.println("3스트라이크");
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    static boolean result(int ball, int strike) {
        if (strike == 3) {
            Print.threeStrike();
            return true;
        }
        if (ball == 0 && strike == 0) {
            Print.nothing();
        }
        if (ball > 0) {
            System.out.print(ball + "볼 ");
        }
        if (strike > 0) {
            System.out.print(strike + "스트라이크 ");
        }
        System.out.println();
        return false;
    }
}
