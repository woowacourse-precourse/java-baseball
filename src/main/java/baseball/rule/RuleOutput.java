package baseball.rule;

import baseball.GameMessage;

public class RuleOutput {
    public static void showResult(int ball, int strike) {
        showNothing(ball, strike);
        if (strike == 3) {
            showStrike(strike);
            System.out.println(GameMessage.GAME_END);
        } else if (strike > 0 && strike < 3) {
            showBall(ball);
            showStrike(strike);
        } else if (strike == 0 && ball > 0) {
            showBall(ball);
            System.out.println();
        }
    }

    private static void showNothing(int ball, int strike) {
        if ((ball == 0) && (strike == 0)) {
            System.out.println(GameMessage.NOTHING);
        }
    }

    private static void showBall(int ball) {
        if (ball > 0) {
            System.out.print(ball + GameMessage.BALL);
        }
    }

    private static void showStrike(int strike) {
        System.out.println(strike + GameMessage.STRIKE);
    }
}
