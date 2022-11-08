package baseball.view.print;

public class PrintHint {
    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static void printBall(int ball) {
        System.out.printf("%d" + BALL_MESSAGE + "\n", ball);
    }

    public static void printStrike(int strike) {
        System.out.printf("%d" + STRIKE_MESSAGE + "\n", strike);
    }

    public static void printBallAndStrike(int ball, int strike) {
        System.out.printf("%d" + BALL_MESSAGE + " %d" + STRIKE_MESSAGE + "\n", ball, strike);
    }

    public static void printNothing() {
        System.out.println(NOTHING_MESSAGE);
    }
}