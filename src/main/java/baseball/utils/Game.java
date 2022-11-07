package baseball.utils;

import static baseball.values.Constant.Console.*;

public class Game {
    private static int strikeCnt = 0;
    private static int ballCnt = 0;
    private static boolean noting = false;


    private static void printStartText() {
        System.out.println(START_GAME);
    }

    private static void printEndText() {
        System.out.println(END_GAME);
        System.out.println(ASK_RESTART);
    }
}
