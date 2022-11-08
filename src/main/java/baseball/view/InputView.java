package baseball.view;

import java.util.Scanner;

public class InputView {
    public static String scanNumber(){
        String number;

        Scanner scanner = new Scanner(System.in);
        System.out.print("숫자를 입력해주세요 : ");
        number = scanner.nextLine();

        return number;
    }

    public static Integer askContinue(){
        int status;

        Scanner scanner = new Scanner(System.in);
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        status = scanner.nextInt();

        return status;
    }
}
