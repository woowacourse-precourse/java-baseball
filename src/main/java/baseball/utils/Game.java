package baseball.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static baseball.values.Constant.Console.*;
import static baseball.values.Constant.Digit.*;
import static baseball.values.Constant.Hint.*;

public class Game {
    private static int strikeCnt = 0;
    private static int ballCnt = 0;
    private static boolean noting = false;


    public static void start() {
        printStartText();
        game();
    }

    private static void game() {
        List<Integer> computerNums = Baseball.createComputer().getBaseballNumber();
        List<Integer> playerNums;
        String restartCheck;

        resetGameValue();
        while (strikeCnt != MAX_STRIKE_CNT) {
            resetGameValue();
            playerNums = Baseball.createPlayer(Console.readLine()).getBaseballNumber();
            compare(computerNums, playerNums);
            printHint();
        }

        printEndText();
        restartCheck = Console.readLine();
        if (restartCheck.equals(RESTART)) {
            game();
        }
    }

    private static void compare(List<Integer> computerNums, List<Integer> playerNums) {
        int playerNum, computerNum;

        for (int i = 0; i < TOTAL_BALL_CNT; i++) {
            computerNum = computerNums.get(i);
            playerNum = playerNums.get(i);
            checkBallOrStrike(computerNums, playerNum, computerNum);
        }
        if (ballCnt == 0 && strikeCnt == 0) {
            noting = true;
        }
    }

    private static void checkBallOrStrike(List<Integer> computerNums, int playerNum, int computerNum) {
        if (computerNums.contains(playerNum)) {
            if (computerNum == playerNum) {
                strikeCnt++;
                return;
            }
            ballCnt++;
        }
    }

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
