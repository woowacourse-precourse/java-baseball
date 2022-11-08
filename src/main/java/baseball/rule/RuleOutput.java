package baseball.rule;

import baseball.GameMessage;

public class RuleOutput {
    private static final int ZERO = 0;
    private static final int THREE = 3;
    public static void showResult(int ball, int strike) {
        showNothing(ball, strike);
        if (strike == Rule.END_CONDITION) {
            showStrike(strike);
            System.out.println(GameMessage.GAME_END);
        } else if (strike > ZERO && strike < THREE) {
            showBall(ball);
            showStrike(strike);
        } else if (strike == ZERO && ball > ZERO) {
            showBall(ball);
            System.out.println();
        }
    }

    private static void showNothing(int ball, int strike) {
        if ((ball == ZERO) && (strike == ZERO)) {
            System.out.println(GameMessage.NOTHING);
        }
    }

    private static void showBall(int ball) {
        if (ball > ZERO) {
            System.out.print(ball + GameMessage.BALL);
        }
    }

    private static void showStrike(int strike) {
        System.out.println(strike + GameMessage.STRIKE);
    }
}
