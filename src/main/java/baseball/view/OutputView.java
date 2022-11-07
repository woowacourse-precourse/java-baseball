package baseball.view;

public class OutputView {
    private static final String STRIKE_MESSAGE = "%d스트라이크 ";
    private static final String BALL_MESSAGE = "%d볼 ";
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String SUCCESS_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printSuccess() {
        System.out.printf(SUCCESS_MESSAGE + "\n");
    }

    public static void printBallCount(int ball) {
        System.out.printf(BALL_MESSAGE, ball);
    }

    public static void printStrikeCount(int strike) {
        System.out.printf(STRIKE_MESSAGE, strike);
    }

    public static void printResult(int ball, int strike) {
        if (ball > 0) {
            printBallCount(ball);
        }
        if (strike > 0) {
            printStrikeCount(strike);
        }
        if (strike == 0 && ball == 0) {
            System.out.printf(NOTHING_MESSAGE);
        }
        System.out.println();
    }
}
