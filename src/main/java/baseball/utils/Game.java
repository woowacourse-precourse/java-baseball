package baseball.utils;

import static baseball.values.Constant.Console.*;
import static baseball.values.Constant.Hint.*;

public class Game {
    private static int strikeCnt = 0;
    private static int ballCnt = 0;
    private static boolean noting = false;


    private static void printHint() {
        if (noting == true) {
            System.out.println(NOTING);
            return;
        }
        System.out.println(getHint(ballCnt, strikeCnt));
    }

    private static StringBuffer getHint(int ballCnt, int strikeCnt) {
        StringBuffer gameHint = new StringBuffer();
        if (ballCnt > 0) {
            gameHint.append(ballCnt);
            gameHint.append(BALL);
        }
        if (gameHint.length() > 0 && strikeCnt > 0) {
            gameHint.append(SPACE);
        }
        if (strikeCnt > 0) {
            gameHint.append(strikeCnt);
            gameHint.append(STRIKE);
        }
        return gameHint;
    }


    private static void printStartText() {
        System.out.println(START_GAME);
    }

    private static void printEndText() {
        System.out.println(END_GAME);
        System.out.println(ASK_RESTART);
    }

    private static void resetGameValue() {
        strikeCnt = 0;
        ballCnt = 0;
        noting = false;
    }
}
