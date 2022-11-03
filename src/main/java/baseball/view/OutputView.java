package baseball.view;

public class OutputView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";

    public static void printGameResult(int strike, int ball) {
        printStrikeAndBall(strike, ball);
        printOnlyStrike(strike, ball);
        printOnlyBall(strike, ball);
        printNothing(strike, ball);
    }

    private static void printStrikeAndBall(int strike, int ball) {
        if (strike != 0 && ball != 0) {
            System.out.println(ball + BALL + " " + strike + STRIKE);
        }
    }

    private static void printOnlyStrike(int strike, int ball) {
        if (strike != 0 && ball == 0) {
            System.out.println(strike + STRIKE);
        }
    }

    private static void printOnlyBall(int strike, int ball) {
        if (strike == 0 && ball != 0) {
            System.out.println(ball + BALL);
        }
    }

    private static void printNothing(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            System.out.println(NOTHING);
        }
    }
}
