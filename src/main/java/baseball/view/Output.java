package baseball.view;

import baseball.model.BallCounts;

public class Output {
    public static void outputBallCounts(BallCounts ballCounts) {
        outputBall(ballCounts.getBall());
        outputStrike(ballCounts.getStrike());
        outputNothing(ballCounts.getIsNothing());
    }
    public static void outputRestart() {

    }

    private static void outputBall(int countBall) {
        if (countBall != 0) {
            System.out.print(countBall + "볼 ");
        }
    }

    private static void outputStrike(int countStrike) {
        if (countStrike != 0) {
            System.out.print(countStrike + "스트라이크");
        }
    }

    private static void outputNothing(boolean isNothing) {
        if (isNothing) {
            System.out.print("낫싱");
        }
    }

}
