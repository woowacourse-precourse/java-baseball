package view;

public class OutputView {
    public static void printReadPlayerNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
    }

    public static void printStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public static void printReadGameCommand() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    public static void printResult(String result) {
        System.out.println(result);
    }
}
