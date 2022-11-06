package baseball;

public class Computer {

    private static RandomNumber RandomValue;
    private static final int GAMESTARTMODE = 1;
    private static final int INPUTNUMBERMODE = 2;
    private static final int GENERATERANDOMMODE = 3;
    private static final int CALCULATEDOUTPUTMODE = 4;

    public static void printGameStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printInputNumber() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printEndingMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static String printCalculateResult(String calculatedResult) {
        System.out.println(calculatedResult);
        return calculatedResult;
    }

    public static String testComputerPrint(int mode, String input) {
        if (mode == GAMESTARTMODE) {
            printGameStart();
        } else if (mode == INPUTNUMBERMODE) {
            printInputNumber();
        } else if (mode == CALCULATEDOUTPUTMODE) {
            printCalculateResult(input);
        }
        return "";
    }
}