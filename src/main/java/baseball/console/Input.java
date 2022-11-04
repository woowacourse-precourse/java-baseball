package baseball.console;

import java.util.Scanner;

public class Input {

    private static final String inputMessage = "숫자를 입력해주세요 : ";

    public static int get() {
        System.out.print(inputMessage);
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        return number;
    }
}
