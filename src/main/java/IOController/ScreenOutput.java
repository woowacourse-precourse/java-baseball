package IOController;

public class ScreenOutput {

    private static final int GAME_START_MODE = 1;
    private static final int INPUT_NUMBER_MODE = 2;
    private static final int GAME_END_MODE = 3;
    private static final int CALCULATED_OUTPUT_MODE = 4;


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
        if (mode == GAME_START_MODE) {
            printGameStart();
        } else if (mode == INPUT_NUMBER_MODE) {
            printInputNumber();
        } else if (mode == GAME_END_MODE) {
            printEndingMessage();
        } else if (mode == CALCULATED_OUTPUT_MODE) {
            printCalculateResult(input);
        }
        return "";
    }
}