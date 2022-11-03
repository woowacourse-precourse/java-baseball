package baseball.rule;

public class RuleOutput {
    public static void showResult(int ball, int strike) {
        showNothing(ball, strike);
        if (strike == 3) {
            System.out.println("게임 종료");
        } else if (strike > 0 && strike < 3) {
            showBall(ball);
            showStrike(strike);
        } else if (strike == 0) {
            showBall(ball);
            System.out.println();
        }
    }

    private static void showNothing(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            System.out.println("낫싱");
        }
    }

    private static void showBall(int ball) {
        if (ball > 0) {
            System.out.print(ball+"볼 ");
        }
    }

    private static void showStrike(int strike) {
        System.out.println(strike+"스트라이크");
    }
}
