package baseball;

import static baseball.Constants.*;

public class View {

    public static void printStartMsg() {
        System.out.println(START_MSG);
    }

    public static void printInputMsg() {
        System.out.println(INPUT_MSG);
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
        System.out.println(END_MSG);
    }

    public static void printRestartOrEndMsg() {
        System.out.println(RESTART_OR_END_MSG);
    }
}
