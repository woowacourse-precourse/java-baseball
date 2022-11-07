package baseball;

public class SystemMessage {
    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printRequestUserNumber() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public static void printEndMessage() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    public static void printRetryOrQuit() {
        System.out.println("게임을 다시 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}