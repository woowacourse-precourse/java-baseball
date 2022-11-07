package baseball;

public class HintOutput {

    private static final String BALL_MESSAGE = "볼";
    private static final String STRIKE_MESSAGE = "스트라이크";
    private static final String NOTHING_MESSAGE = "낫싱";

    public static boolean printHint(int ball, int strike) {
        if (HintCalculator.isNothing(ball, strike)) {
            System.out.println(NOTHING_MESSAGE);
        } else if (HintCalculator.isThreeStrike(strike)) {
            System.out.println(strike + STRIKE_MESSAGE);
            return true;
        } else if (strike == 0) {
            System.out.println(ball + BALL_MESSAGE);
        } else if (ball == 0) {
            System.out.println(strike + STRIKE_MESSAGE);
        } else {
            System.out.println(ball + BALL_MESSAGE + " " + strike + STRIKE_MESSAGE);
        }
        return false;
    }
}
