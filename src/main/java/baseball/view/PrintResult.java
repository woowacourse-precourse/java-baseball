package baseball.view;

import baseball.domain.BallCount;

public class PrintResult {

    public static void printStartMent(){
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    public static void printBallCount(BallCount ballCount) {
        System.out.println(ballCount.ballCountResult());
    }

    public static void gameClearMent(boolean isgameEnd) {
        if (isgameEnd) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }

}
