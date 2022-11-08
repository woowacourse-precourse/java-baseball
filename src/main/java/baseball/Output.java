package baseball;

public class Output {

    private static final String StartSymbol = "숫자 야구 게임을 시작합니다.";
    private static final String InputSymbol = "숫자를 입력해주세요 : ";
    private static final String EndSymbol = "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n"
        + "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public static void printStartMsg() {
        System.out.println(StartSymbol);
    }

    public static void printInputMsg() {
        System.out.print(InputSymbol);
    }

    public static void printOutput(int ballNum, int strikeNum) {
        if (ballNum > 0) {
            System.out.print(ballNum + "볼 ");
        }
        if (strikeNum > 0) {
            System.out.print(strikeNum + "스트라이크");
        }
        if (ballNum == 0 && strikeNum == 0) {
            System.out.print("낫싱");
        }
        System.out.println();
    }

    public static void printEndMsg() {
        System.out.println(EndSymbol);
    }
}
