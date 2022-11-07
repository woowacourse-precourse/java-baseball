package baseball.view;

import baseball.utils.BallValidator;

public class OutputView {
    private static final String STRIKE = "스트라이크";
    private static final String BALL = "볼";
    private static final String NOTHING = "낫싱";
    private static final String GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printGameResult(int strike, int ball) {
        printStrikeAndBall(strike, ball);
        printOnlyStrike(strike, ball);
        printOnlyBall(strike, ball);
        printNothing(strike, ball);
        printGameEnd(strike, ball);
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

    private static void printGameEnd(int strike, int ball) {
        if (strike == BallValidator.MAX_BALL_SIZE && ball == 0) {
            System.out.println(GAME_END);
        }
    }
}
