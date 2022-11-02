package baseball;

import java.util.Scanner;

public class Application {

    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application application = new Application();
        application.run();



    }

    public void run() {
        System.out.println("숫자 야구 게임을 시작합니다.");
        while (true) {
            System.out.println("숫자를 입력해주세요 : ");
            String input = scanner.nextLine();
        }
    }
}
