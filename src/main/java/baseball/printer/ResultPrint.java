package baseball.printer;

import baseball.data.PrintData;

/**
 * 출력을 담당하는 클래스
 */
public class ResultPrint {
    public static void printGuessResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            PrintData.printStringData("NOTHING");
            PrintData.printLine();
            return;
        }
        if (ball > 0) {
            System.out.print(ball);
            PrintData.printStringData("BALL");
            PrintData.printSpace();
        }
        if (strike > 0) {
            System.out.print(strike);
            PrintData.printStringData("STRIKE");
            if (strike == 3) {
                PrintData.printLine();
                PrintData.printStringData("ALL_STRIKES");
            }
        }
        PrintData.printLine();
    }
}
