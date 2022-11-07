package baseball.view;

import baseball.domain.BallCount;

public class PrintResult {

    public static void printBallCount(BallCount ballCount) {
        System.out.println(ballCount.ballCountResult());
    }

    public static void gameClearMent(boolean isgameEnd) {
        if (isgameEnd) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
