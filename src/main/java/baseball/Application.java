package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        printGameStartMessage();
            printGameRestartMessage();
    }

    static void printGameStartMessage() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }
    static void printGameRestartMessage() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
