package baseball.view;

import static java.lang.System.out;

import baseball.domain.BallCount;

public class PrintResult {

    private static final String START_BASEBALL_GAME = "숫자 야구 게임을 시작합니다.";
    private static final String GAME_CLEAR_MENT = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";

    public static void printStartMent() {
        out.println(START_BASEBALL_GAME);
    }

    public static void printBallCount(BallCount ballCount) {
        out.println(ballCount.ballCountResult());
    }

    public static void gameClearMent(boolean isgameEnd) {
        if (isgameEnd) {
            out.println(GAME_CLEAR_MENT);
        }
    }

}
