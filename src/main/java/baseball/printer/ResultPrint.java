package baseball.printer;

/**
 * 출력을 담당하는 클래스
 */
public class ResultPrint {
    public static void printGuessResult(int strike, int ball) {
        if (strike == 0 && ball == 0) {
            PrintData.printData("NOTHING");
            PrintData.printLine();
            return;
        }
        if (ball > 0) {
            System.out.print(ball);
            PrintData.printData("BALL");
            PrintData.printSpace();
        }
        if (strike > 0) {
            System.out.print(strike);
            PrintData.printData("STRIKE");
            if (strike == 3) {
                PrintData.printLine();
                PrintData.printData("ALL_STRIKES");
            }
        }
        PrintData.printLine();
    }
}
