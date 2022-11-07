package baseball.view;

import baseball.domain.BallCount;

public class PrintResult {

    public static void printBallCount(BallCount ballCount) {
        System.out.println(ballCount.ballCountResult());
    }

}
