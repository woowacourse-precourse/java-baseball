package baseball.console;

import java.util.Scanner;

public class Input {
    private static final String inputMessage = "숫자를 입력해주세요 : ";

    public static String get() {
        System.out.print(inputMessage);
        Scanner scanner = new Scanner(System.in);
        String number = scanner.nextLine();
        return number;
    }
}
