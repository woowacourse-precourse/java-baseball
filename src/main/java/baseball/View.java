package baseball;

import static baseball.Constants.*;

public class View {

    public static void printStartMsg() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputMsg() {
        System.out.println("숫자를 입력해주세요 : ");
    }

    public static void printHintMsg(int[] results) {
        int strikeCnt = results[STRIKE_IDX];
        int ballCnt = results[BALL_IDX];
        if (strikeCnt == 0 && ballCnt == 0) {
            System.out.println(NOTHING);
        } else if (strikeCnt == 0 && ballCnt > 0) {
            System.out.println(ballCnt + BALL);
        } else if (ballCnt == 0 && strikeCnt > 0) {
            System.out.println(strikeCnt + STRIKE);
        } else if (strikeCnt > 0 && ballCnt > 0) {
            System.out.println(ballCnt + BALL + BLANK + strikeCnt + STRIKE);
        }
    }

    public static void printEndMsg() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRestartOrEndMsg() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
